package com.example.a160418047_uts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reward (
    @ColumnInfo(name = "nama")
    val  nama:String?,
    @ColumnInfo(name = "info")
    val info:String?,
    @ColumnInfo(name = "quatity")
    val quatity:Int
        )
{
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}