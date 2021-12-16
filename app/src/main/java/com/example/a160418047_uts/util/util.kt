package com.example.a160418047_uts.util

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a160418047_uts.R
import com.example.a160418047_uts.model.RecipeDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE

            }

            override fun onError(e: Exception?) {
            }
        })
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoUrl(view: ImageView, url: String?, pb: ProgressBar) {
    view.loadImage(url, pb)
}


val DB_NAME="Recipedb"
fun buildDb(context: Context):RecipeDatabase {
    val db = Room.databaseBuilder(context, RecipeDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Recipe ADD COLUMN cat TEXT DEFAULT 'makanan dasar' ")
    }
}


