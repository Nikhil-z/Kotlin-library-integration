package com.nikhilz.sam

import android.app.Application
import com.nikhilz.empire.Castle

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        Castle.init(instance)

    }

    companion object {
        lateinit var instance: App
            private set
    }
}