package com.johnyang.tencentsuperplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import com.tencent.liteav.demo.play.SuperPlayerGlobalConfig;
import com.tencent.liteav.demo.play.SuperPlayerModel;
import com.tencent.liteav.demo.play.SuperPlayerView;
import com.tencent.rtmp.TXLiveConstants;

public class MainActivity extends AppCompatActivity {

    private SuperPlayerView mSuperPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //仅去掉标题栏，系统状态栏还是会显示
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //去掉系统状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        mSuperPlayerView = findViewById(R.id.main_super_player_view);
        // 播放器配置
        SuperPlayerGlobalConfig prefs = SuperPlayerGlobalConfig.getInstance();
        // 开启悬浮窗播放
        prefs.enableFloatWindow = true;
        // 设置悬浮窗的初始位置和宽高
        SuperPlayerGlobalConfig.TXRect rect = new SuperPlayerGlobalConfig.TXRect();
        rect.x = 0;
        rect.y = 0;
        rect.width = 810;
        rect.height = 540;
        prefs.floatViewRect = rect;
        // 播放器默认缓存个数
        prefs.maxCacheItem = 5;
        // 设置播放器渲染模式
        prefs.enableHWAcceleration = true;
        prefs.renderMode = TXLiveConstants.RENDER_MODE_ADJUST_RESOLUTION;

        // 通过URL方式的视频信息配置
        SuperPlayerModel model2 = new SuperPlayerModel();
        model2.title  = "测试视频-720P";
        model2.url = "http://1252463788.vod2.myqcloud.com/95576ef5vodtransgzp1252463788/68e3febf4564972819220421305/v.f30.mp4";
        // 开始播放
        mSuperPlayerView.playWithModel(model2);

    }
}
