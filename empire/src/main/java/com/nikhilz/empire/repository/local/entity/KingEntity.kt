package com.nikhilz.empire.repository.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(indices = [Index(value = ["title"], unique = true)])
open class KingEntity(
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "type")
    var type: Int,
    @ColumnInfo(name = "total")
    var total: Long
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subtitle")
    var id: Long? = null
}