package com.hs.administrator.test.videoplayer;

/**
 * Created by Administrator on 2017/11/8.
 */

public interface BuriedPoint {

    void POINT_START_ICON(String title, String url);

    void POINT_START_THUMB(String title, String url);

    void POINT_STOP(String title, String url);

    void POINT_STOP_FULLSCREEN(String title, String url);

    void POINT_RESUME(String title, String url);

    void POINT_RESUME_FULLSCREEN(String title, String url);

    void POINT_CLICK_BLANK(String title, String url);

    void POINT_CLICK_BLANK_FULLSCREEN(String title, String url);

    void POINT_CLICK_SEEKBAR(String title, String url);

    void POINT_CLICK_SEEKBAR_FULLSCREEN(String title, String url);

    void POINT_AUTO_COMPLETE(String title, String url);

    void POINT_AUTO_COMPLETE_FULLSCREEN(String title, String url);

    void POINT_ENTER_FULLSCREEN(String title, String url);

    void POINT_QUIT_FULLSCREEN(String title, String url);
}
