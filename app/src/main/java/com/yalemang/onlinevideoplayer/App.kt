package com.yalemang.onlinevideoplayer

import android.app.Application
import com.shuyu.gsyvideoplayer.player.PlayerFactory
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager


class App:Application() {

    override fun onCreate() {
        super.onCreate()
        PlayerFactory.setPlayManager(Exo2PlayerManager::class.java)
    }

}