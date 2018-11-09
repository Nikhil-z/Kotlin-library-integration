package com.nikhilz.empire.repository.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nikhilz.empire.repository.local.entity.KingEntity


@Dao
interface KingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(kingEntity: KingEntity)

    @Query("SELECT * from KingEntity")
    fun getAll(): LiveData<List<KingEntity>>

}