package com.nikhilz.sam.repository.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nikhilz.empire.repository.local.entity.KingEntity
import com.nikhilz.sam.repository.local.entity.ManagerEntity


@Dao
interface ManagerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(managerEntity: ManagerEntity)

    @Query("SELECT * from ManagerEntity")
    fun getAll(): LiveData<List<ManagerEntity>>

}