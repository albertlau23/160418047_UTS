package com.example.a160418047_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.RecipeDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class itemRecipeDetailViewModel(application: Application):AndroidViewModel(application),CoroutineScope {
    val recipeLd= MutableLiveData<Recipe>()
    private val job= Job();
    fun addRecipe(list:List<Recipe>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), RecipeDatabase::class.java,
                "Recipedb").build()
            db.recipeDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    //val recipeLoadErrorLd= MutableLiveData<Boolean>()
    //val loadingld= MutableLiveData<Boolean>()
    fun fetch(id:Int) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), RecipeDatabase::class.java,
                "Recipedb").build()
            recipeLd.value=db.recipeDao().selectRecipe(id)
        }
    }

}