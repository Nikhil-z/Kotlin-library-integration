package com.nikhilz.empire.repository

import android.app.Application
import com.nikhilz.empire.Castle
import com.nikhilz.empire.repository.local.Treasure
import com.nikhilz.empire.repository.local.Neighbourhood

class Cabinet {

    companion object {

        val database = Treasure.getInstance(Castle.instance)
        val neighbourhood = Neighbourhood() /*All neighbourhood data operation take place from here*/

    }
}