package com.ksg.ksgplayer.renderer;

import android.view.View;

/**
 * @ClassName: RenderMeasure
 * @Author: KaiSenGao
 * @CreateDate: 2022/3/1 16:24
 * @Description: 视图宽高比算法
 */
public final class RendererMeasure {

    private int mVideoWidth;
    private int mVideoHeight;

    private int mVideoSarNum;
    private int mVideoSarDen;

    private int mMeasureWidth;
    private int mMeasureHeight;

    private int mVideoRotationDegree;

    private AspectRatio mCurrAspectRatio = AspectRatio.AspectRatio_FIT_PARENT;

    public void doMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (mVideoRotationDegree == 90 || mVideoRotationDegree == 270) {
            int tempSpec = widthMeasureSpec;
            widthMeasureSpec = heightMeasureSpec;
            heightMeasureSpec = tempSpec;
        }

        int width = View.getDefaultSize(mVideoWidth, widthMeasureSpec);
        int height = View.getDefaultSize(mVideoHeight, heightMeasureSpec);
        if (mCurrAspectRatio == AspectRatio.AspectRatio_MATCH_PARENT) {
            width = widthMeasureSpec;
            height = heightMeasureSpec;
        } else if (mVideoWidth > 0 && mVideoHeight > 0) {
            int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
            int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
            int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
            int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);

            if (widthSpecMode == View.MeasureSpec.AT_MOST && heightSpecMode == View.MeasureSpec.AT_MOST) {
                float specAspectRatio = (float) widthSpecSize / (float) heightSpecSize;
                float displayAspectRatio;
                switch (mCurrAspectRatio) {
                    case AspectRatio_16_9:
                        displayAspectRatio = 16.0f / 9.0f;
                        if (mVideoRotationDegree == 90 || mVideoRotationDegree == 270)
                            displayAspectRatio = 1.0f / displayAspectRatio;
                        break;
                    case AspectRatio_4_3:
                        displayAspectRatio = 4.0f / 3.0f;
                        if (mVideoRotationDegree == 90 || mVideoRotationDegree == 270)
                            displayAspectRatio = 1.0f / displayAspectRatio;
                        break;
                    case AspectRatio_FIT_PARENT:
                    case AspectRatio_FILL_PARENT:
                    case AspectRatio_ORIGIN:
                        //------2018/09/06 add------
                    case AspectRatio_FILL_WIDTH:
                    case AspectRatio_FILL_HEIGHT:
                        //------2018/09/06 add------
                    default:
                        displayAspectRatio = (float) mVideoWidth / (float) mVideoHeight;
                        if (mVideoSarNum > 0 && mVideoSarDen > 0)
                            displayAspectRatio = displayAspectRatio * mVideoSarNum / mVideoSarDen;
                        break;
                }
                boolean shouldBeWider = displayAspectRatio > specAspectRatio;

                switch (mCurrAspectRatio) {
                    case AspectRatio_FIT_PARENT:
                    case AspectRatio_16_9:
                    case AspectRatio_4_3:
                        if (shouldBeWider) {
                            // too wide, fix width
                            width = widthSpecSize;
                            height = (int) (width / displayAspectRatio);
                        } else {
                            // too high, fix height
                            height = heightSpecSize;
                            width = (int) (height * displayAspectRatio);
                        }
                        break;
                    case AspectRatio_FILL_PARENT:
                        if (shouldBeWider) {
                            // not high enough, fix height
                            height = heightSpecSize;
                            width = (int) (height * displayAspectRatio);
                        } else {
                            // not wide enough, fix width
                            width = widthSpecSize;
                            height = (int) (width / displayAspectRatio);
                        }
                        break;
                    //------2018/09/06 add------
                    case AspectRatio_FILL_WIDTH:
                        width = widthSpecSize;
                        height = widthSpecSize * mVideoHeight / mVideoWidth;
                        break;
                    case AspectRatio_FILL_HEIGHT:
                        height = heightSpecSize;
                        width = heightSpecSize * mVideoWidth / mVideoHeight;
                        break;
                    //------2018/09/06 add------
                    case AspectRatio_ORIGIN:
                    default:
                        if (shouldBeWider) {
                            // too wide, fix width
                            width = Math.min(mVideoWidth, widthSpecSize);
                            height = (int) (width / displayAspectRatio);
                        } else {
                            // too high, fix height
                            height = Math.min(mVideoHeight, heightSpecSize);
                            width = (int) (height * displayAspectRatio);
                        }
                        break;
                }
            } else if (widthSpecMode == View.MeasureSpec.EXACTLY && heightSpecMode == View.MeasureSpec.EXACTLY) {
                // the size is fixed
                width = widthSpecSize;
                height = heightSpecSize;

                // for compatibility, we adjust size based on aspect ratio
                if (mVideoWidth * height < width * mVideoHeight) {
                    //Log.i("@@@", "image too wide, correcting");
                    width = height * mVideoWidth / mVideoHeight;
                } else if (mVideoWidth * height > width * mVideoHeight) {
                    //Log.i("@@@", "image too tall, correcting");
                    height = width * mVideoHeight / mVideoWidth;
                }
            } else if (widthSpecMode == View.MeasureSpec.EXACTLY) {
                // only the width is fixed, adjust the height to match aspect ratio if possible
                width = widthSpecSize;
                height = width * mVideoHeight / mVideoWidth;
                if (heightSpecMode == View.MeasureSpec.AT_MOST && height > heightSpecSize) {
                    // couldn't match aspect ratio within the constraints
                    height = heightSpecSize;
                }
            } else if (heightSpecMode == View.MeasureSpec.EXACTLY) {
                // only the height is fixed, adjust the width to match aspect ratio if possible
                height = heightSpecSize;
                width = height * mVideoWidth / mVideoHeight;
                if (widthSpecMode == View.MeasureSpec.AT_MOST && width > widthSpecSize) {
                    // couldn't match aspect ratio within the constraints
                    width = widthSpecSize;
                }
            } else {
                // neither the width nor the height are fixed, try to use actual video size
                width = mVideoWidth;
                height = mVideoHeight;
                if (heightSpecMode == View.MeasureSpec.AT_MOST && height > heightSpecSize) {
                    // too tall, decrease both width and height
                    height = heightSpecSize;
                    width = height * mVideoWidth / mVideoHeight;
                }
                if (widthSpecMode == View.MeasureSpec.AT_MOST && width > widthSpecSize) {
                    // too wide, decrease both width and height
                    width = widthSpecSize;
                    height = width * mVideoHeight / mVideoWidth;
                }
            }
        } else {
            // no size yet, just adopt the given spec sizes
        }

        mMeasureWidth = width;
        mMeasureHeight = height;
    }

    public void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen) {
        this.mVideoSarNum = videoSarNum;
        this.mVideoSarDen = videoSarDen;
    }

    public void setVideoSize(int videoWidth, int videoHeight) {
        this.mVideoWidth = videoWidth;
        this.mVideoHeight = videoHeight;
    }

    public void setVideoRotation(int videoRotationDegree) {
        this.mVideoRotationDegree = videoRotationDegree;
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.mCurrAspectRatio = aspectRatio == null ? AspectRatio.AspectRatio_FIT_PARENT : aspectRatio;
    }

    public int getMeasureWidth() {
        return mMeasureWidth;
    }

    public int getMeasureHeight() {
        return mMeasureHeight;
    }
}
