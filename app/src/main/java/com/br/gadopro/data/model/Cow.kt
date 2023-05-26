package com.br.gadopro.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cows")
data class Cow(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "cow_name") val name: String,
    @ColumnInfo(name = "cow_age") val age: String,
    @ColumnInfo(name = "cow_calve") val calve: String
)
