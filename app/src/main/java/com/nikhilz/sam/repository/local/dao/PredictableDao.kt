package com.nikhilz.sam.repository.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nikhilz.sam.repository.local.entity.PredictableEntity

@Dao
interface PredictableDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(predictableEntity: PredictableEntity)

    @Query("SELECT * from PredictableEntity")
    fun getPredictions(): LiveData<List<PredictableEntity>>
}