package com.nikhilz.empire

import android.app.Application

open class Castle {


    companion object {

        lateinit var instance: Application

        fun init(application: Application) {
            this.instance = application
        }

        fun kingdom(): Kingdom {
            return Kingdom()
        }

    }
}

