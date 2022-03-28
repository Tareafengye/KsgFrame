package com.kasiengao.ksgframe.ui.main.bean;

import com.google.gson.annotations.SerializedName;
import com.kasiengao.ksgframe.R;
import com.kasiengao.ksgframe.common.util.TextUtil;
import com.kasiengao.ksgframe.player.entity.VideoEntity;

/**
 * @ClassName: VideoBean
 * @Author: KaiSenGao
 * @CreateDate: 2022/3/26 17:22
 * @Description:
 */
public class VideoBean extends VideoEntity {

    @SerializedName("movieName")
    private String mMovieName;
    @SerializedName("heightUrl")
    private String mVideoUrl;
    @SerializedName("videoTitle")
    private String mVideoTitle;
    @SerializedName("coverImg")
    private String mCoverImg;

    private String mAvatar;

    private String mNickname;

    private String mProfile;

    private int mPraise;

    private int mComment;

    private int mShare;

    private boolean isPraised;

    private boolean isStepped;

    public VideoBean(String avatar, String nickname, String profile) {
        this.mAvatar = avatar;
        this.mNickname = nickname;
        this.mProfile = profile;
    }

    public String getMovieName() {
        return mMovieName;
    }

    @Override
    public String getVideoUrl() {
        return mVideoUrl;
    }

    public String getVideoTitle() {
        return mVideoTitle;
    }

    public String getCoverImg() {
        return mCoverImg;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        this.mAvatar = avatar;
    }

    public String getNickname() {
        return mNickname;
    }

    public void setNickname(String nickname) {
        this.mNickname = nickname;
    }

    public void setProfile(String profile) {
        this.mProfile = profile;
    }

    public String getProfile() {
        return mProfile;
    }

    public String getPraise() {
        if (mPraise <= 0) {
            return TextUtil.getString(R.string.main_video_item_interact_praise);
        }
        return String.valueOf(mPraise);
    }

    public void setPraise(int praise) {
        this.mPraise = praise;
    }

    public void addPraise() {
        this.mPraise = mPraise + 1;
    }

    public void subPraise() {
        this.mPraise = mPraise - 1;
    }

    public String getComment() {
        if (mComment <= 0) {
            return TextUtil.getString(R.string.main_video_item_interact_comment);
        }
        return String.valueOf(mComment);
    }

    public void setComment(int comment) {
        this.mComment = comment;
    }

    public String getShare() {
        if (mShare <= 0) {
            return TextUtil.getString(R.string.main_video_item_interact_share);
        }
        return String.valueOf(mShare);
    }

    public void setShare(int share) {
        this.mShare = share;
    }

    public boolean isPraised() {
        return isPraised;
    }

    public void setPraised(boolean praise) {
        this.isPraised = praise;
    }

    public boolean isStepped() {
        return isStepped;
    }

    public void setStepped(boolean stepped) {
        this.isStepped = stepped;
    }
}
