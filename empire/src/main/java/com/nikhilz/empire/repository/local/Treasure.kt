package com.nikhilz.empire.repository.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.nikhilz.empire.repository.local.dao.KingDao
import com.nikhilz.empire.repository.local.entity.KingEntity

@Database(entities = [KingEntity::class], version = 1, exportSchema = false)
abstract class Treasure : RoomDatabase() {


    abstract fun kingDao(): KingDao

    companion object {
        @Volatile
        private var sInstance: Treasure? = null

        /**
         * Gets the singleton instance of Database.
         *
         * @param context The context.
         * @return The singleton instance of Database.
         */
        @Synchronized
        fun getInstance(context: Context): Treasure {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, Treasure::class.java, "empire")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }
}