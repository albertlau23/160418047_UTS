package com.example.a160418047_uts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "username")
    val username: String?,
    @ColumnInfo(name = "nama")
    val nama: String?,
    @ColumnInfo(name = "bod")
    val bod: String?,
    @ColumnInfo(name = "phone")
    val phone: String?,
    @ColumnInfo(name = "imgurl")
    val imgurl: String?,
    @ColumnInfo(name = "password")
    val password: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 1
}