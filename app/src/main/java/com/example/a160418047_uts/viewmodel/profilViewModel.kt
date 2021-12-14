package com.example.a160418047_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.RecipeDatabase
import com.example.a160418047_uts.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class profilViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {
    val profilLd = MutableLiveData<User>()
    private var jab = Job()
    override val coroutineContext: CoroutineContext
        get() = jab + Dispatchers.Main

    fun fetch(id: String) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), RecipeDatabase::class.java,
                "Recipedb"
            ).build()
            profilLd.value = db.userDao().viewUser(id)
        }

    }


}