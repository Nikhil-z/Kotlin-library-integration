package com.nikhilz.sam.repository

import com.nikhilz.sam.App
import com.nikhilz.sam.repository.local.AppDB
import com.nikhilz.sam.repository.local.Local

class DataRepository {

    companion object {

        val database = AppDB.getInstance(App.instance)
        val local = Local() /*All neighbourhood data operation take place from here*/

    }
}