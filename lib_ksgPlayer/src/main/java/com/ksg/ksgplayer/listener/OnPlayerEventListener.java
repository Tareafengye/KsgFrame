package com.ksg.ksgplayer.listener;

import android.os.Bundle;

import com.ksg.ksgplayer.player.IKsgPlayer;

/**
 * @ClassName: OnPlayerEventListener
 * @Author: KaiSenGao
 * @CreateDate: 2020/5/22 13:22
 * @Description: 播放器的基础事件
 */
public interface OnPlayerEventListener {

    /**
     * when decoder set data source
     */
    int PLAYER_EVENT_ON_DATA_SOURCE_SET = -99001;

    /**
     * when surface holder update
     */
    int PLAYER_EVENT_ON_SURFACE_HOLDER_UPDATE = -99002;

    /**
     * when surface update
     */
    int PLAYER_EVENT_ON_SURFACE_UPDATE = -99003;

    /**
     * when you call {@link IKsgPlayer#start()}
     */
    int PLAYER_EVENT_ON_START = -99004;

    /**
     * when you call {@link IKsgPlayer#pause()}
     */
    int PLAYER_EVENT_ON_PAUSE = -99005;

    /**
     * when you call {@link IKsgPlayer#resume()}
     */
    int PLAYER_EVENT_ON_RESUME = -99006;

    /**
     * when you call {@link IKsgPlayer#stop()}
     */
    int PLAYER_EVENT_ON_STOP = -99007;

    /**
     * when you call {@link IKsgPlayer#reset()}
     */
    int PLAYER_EVENT_ON_RESET = -99008;

    /**
     * when you call {@link IKsgPlayer#destroy()}
     */
    int PLAYER_EVENT_ON_DESTROY = -99009;

    /**
     * when decoder start buffering stream
     */
    int PLAYER_EVENT_ON_BUFFERING_START = -99010;

    /**
     * when decoder buffering stream end
     */
    int PLAYER_EVENT_ON_BUFFERING_END = -99011;

    /**
     * when decoder buffering percentage update
     */
    @Deprecated
    int PLAYER_EVENT_ON_BUFFERING_UPDATE = -99012;

    /**
     * when you call {@link IKsgPlayer#seekTo(int)}
     */
    int PLAYER_EVENT_ON_SEEK_TO = -99013;

    /**
     * when seek complete
     */
    int PLAYER_EVENT_ON_SEEK_COMPLETE = -99014;

    /**
     * when player start render video stream
     */
    int PLAYER_EVENT_ON_VIDEO_RENDER_START = -99015;

    /**
     * when play complete
     */
    int PLAYER_EVENT_ON_PLAY_COMPLETE = -99016;

    /**
     * on video size change
     */
    int PLAYER_EVENT_ON_VIDEO_SIZE_CHANGE = -99017;

    /**
     * on decoder prepared
     */
    int PLAYER_EVENT_ON_PREPARED = -99018;

    /**
     * NONE
     */
    int PLAYER_EVENT_ON_NONE = -99019;

    /**
     * on get video rotation.
     */
    int PLAYER_EVENT_ON_VIDEO_ROTATION_CHANGED = 99020;

    /**
     * when player start render audio stream
     */
    int PLAYER_EVENT_ON_AUDIO_RENDER_START = -99021;

    /**
     * when audio decoder start
     */
    int PLAYER_EVENT_ON_AUDIO_DECODER_START = -99022;

    /**
     * when audio seek rendering start
     */
    int PLAYER_EVENT_ON_AUDIO_SEEK_RENDERING_START = -99023;

    /**
     * network bandwidth
     */
    int PLAYER_EVENT_ON_NETWORK_BANDWIDTH = -99024;

    /**
     * bad interleaving
     */
    int PLAYER_EVENT_ON_BAD_INTERLEAVING = -99025;

    /**
     * not support seek ,may be live.
     */
    int PLAYER_EVENT_ON_NOT_SEEK_ABLE = -99026;

    /**
     * on meta data update
     */
    int PLAYER_EVENT_ON_METADATA_UPDATE = -99027;

    /**
     * Failed to handle timed text track properly.
     */
    int PLAYER_EVENT_ON_TIMED_TEXT_ERROR = -99028;

    /**
     * Subtitle track was not supported by the media framework.
     */
    int PLAYER_EVENT_ON_UNSUPPORTED_SUBTITLE = -99029;

    /**
     * Reading the subtitle track takes too long.
     */
    int PLAYER_EVENT_ON_SUBTITLE_TIMED_OUT = -99030;

    /**
     * on play status update
     */
    int PLAYER_EVENT_ON_STATUS_CHANGE = -99031;


    /**
     * if you set data provider for player, call back this method when provider start load data.
     */
    int PLAYER_EVENT_ON_PROVIDER_DATA_START = -99050;

    /**
     * call back this method when provider load data success.
     */
    int PLAYER_EVENT_ON_PROVIDER_DATA_SUCCESS = -99051;

    /**
     * call back this method when provider load data error.
     */
    int PLAYER_EVENT_ON_PROVIDER_DATA_ERROR = -99052;

    /**
     * 发送事件
     *
     * @param eventCode eventCode
     * @param bundle    bundle
     */
    void onPlayerEvent(int eventCode, Bundle bundle);
}
