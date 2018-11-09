package com.nikhilz.sam.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nikhilz.sam.repository.local.dao.ManagerDao
import com.nikhilz.sam.repository.local.dao.PredictableDao
import com.nikhilz.sam.repository.local.entity.ManagerEntity
import com.nikhilz.sam.repository.local.entity.PredictableEntity

@Database(entities = [PredictableEntity::class, ManagerEntity::class], version = 2, exportSchema = false)
abstract class AppDB : RoomDatabase() {


    abstract fun predictableDao(): PredictableDao
    abstract fun managerDao(): ManagerDao

    companion object {
        @Volatile
        private var sInstance: AppDB? = null

        /**
         * Gets the singleton instance of Database.
         *
         * @param context The context.
         * @return The singleton instance of Database.
         */
        @Synchronized
        fun getInstance(context: Context): AppDB {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDB::class.java, "prediction")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }
}