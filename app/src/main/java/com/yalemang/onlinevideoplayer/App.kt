package com.yalemang.onlinevideoplayer

import android.app.Application
import com.arialyy.aria.core.Aria
import com.arialyy.aria.core.download.m3u8.M3U8VodOption
import com.shuyu.gsyvideoplayer.cache.CacheFactory
import com.shuyu.gsyvideoplayer.player.PlayerFactory
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager


class App:Application() {

    override fun onCreate() {
        super.onCreate()
        //m3u8支持
        PlayerFactory.setPlayManager(Exo2PlayerManager::class.java)
        CacheFactory.setCacheManager(ExoPlayerCacheManager::class.java)

        Aria.download(this).register() //注册aria

    }

}