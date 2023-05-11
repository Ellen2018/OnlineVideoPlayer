package com.yalemang.onlinevideoplayer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arialyy.aria.core.Aria
import com.arialyy.aria.core.download.m3u8.M3U8VodOption
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import java.io.File

/**
 * 1.m3u8的在线播放
 * 2.m3u8的下载与播放
 * 3.m3u8投屏
 */
class MainActivity : AppCompatActivity() {

    private val permissionUtils = PermissionUtils(this)

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
        permissionUtils.startCheckFileReadWritePermission(0,object :
            PermissionUtils.PermissionCallback {
            override fun success() {
                Toast.makeText(this@MainActivity,"开始下载",Toast.LENGTH_SHORT).show()
                downLoadAndPlay()
            }

            override fun failure() {

            }
        })
    }

    /**
     * 在线播放
     */
    private fun onlineM3U8Play(){
        standardGSYVideoPlayer = findViewById(R.id.video_player)
        standardGSYVideoPlayer.setUp(testM3U8Array[1],true,"测试m3u8")
    }

    private fun downLoadAndPlay(){
        val option = M3U8VodOption() // 创建m3u8点播文件配
        option.setUseDefConvert(false)
        option.generateIndexFile()
        val file = File(cacheDir,"test.video")
        val taskId: Long = Aria.download(this)
            .load(testM3U8Array[1]) //读取下载地址
            .setFilePath(file.absolutePath) //设置文件保存的完整路径
            .m3u8VodOption(option)   // 调整下载模式为m3u8点播
            .create() //创建并启动下载

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}