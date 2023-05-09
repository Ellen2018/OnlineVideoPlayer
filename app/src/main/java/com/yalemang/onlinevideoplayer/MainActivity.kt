package com.yalemang.onlinevideoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var standardGSYVideoPlayer: StandardGSYVideoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        standardGSYVideoPlayer = findViewById(R.id.video_player)
        val url = "https://mirror.aarnet.edu.au/pub/TED-talks/911Mothers_2010W-480p.mp4"
        standardGSYVideoPlayer.setUp(url,true,"测试m3u8")
    }
}