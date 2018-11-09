package com.nikhilz.sam.repository.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["predication"], unique = true)])
class PredictableEntity(

    @ColumnInfo(name = "predication")
    var title: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subtitle")
    var id: Long? = null
}