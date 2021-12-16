package com.example.a160418047_uts.model

import androidx.room.*

@Entity
data class Recipe(

    @ColumnInfo(name = "namaResep")
    var nama: String?,
    @ColumnInfo(name = "bahan")
    var bahan: String?,
    @ColumnInfo(name = "cara")
    var cara: String?,
    @ColumnInfo(name = "url")
    var url: String?,
    @ColumnInfo(name="cat")
    var cat:String,
    @ColumnInfo(name = "uid")
    var uid: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}


