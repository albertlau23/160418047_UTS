package com.example.a160418047_uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a160418047_uts.util.MIGRATION_1_2


@Database(entities = arrayOf(Recipe::class,User::class,Reward::class), version = 2)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    abstract fun userDao(): UserDao
    abstract fun rewardDao(): RewardDao

    companion object {
        @Volatile
        private var instance: RecipeDatabase? = null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                com.example.a160418047_uts.model.RecipeDatabase::class.java,
                "Recipedb"
            ).addMigrations(MIGRATION_1_2).build()


        operator fun invoke(context: Context) {
            if (instance != null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }


    }
}

