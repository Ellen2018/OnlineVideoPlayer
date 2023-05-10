package com.yalemang.onlinevideoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

/**
 * 1.m3u8的在线播放
 * 2.m3u8的下载与播放
 * 3.m3u8投屏
 */
class MainActivity : AppCompatActivity() {

    private var testM3U8Array = arrayOf(
        "https://ask.dcloud.net.cn/topic/m3u8",//无效
        "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8",
        "https://vkceyugu.cdn.bspapp.com/VKCEYUGU-uni4934e7b/c4d93960-5643-11eb-a16f-5b3e54966275.m3u8",//无效
        "http://cctvalih5ca.v.myalicdn.com/live/cctv1_2/index.m3u8"//无效
    )

    private lateinit var standardGSYVideoPlayer: StandardGSYVideoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onlineM3U8Play()
    }

    /**
     * 在线播放
     */
    private fun onlineM3U8Play(){
        standardGSYVideoPlayer = findViewById(R.id.video_player)
        standardGSYVideoPlayer.setUp(testM3U8Array[1],true,"测试m3u8")
    }
}