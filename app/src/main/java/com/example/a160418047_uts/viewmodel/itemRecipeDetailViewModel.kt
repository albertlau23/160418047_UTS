package com.example.a160418047_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.RecipeDatabase
import com.example.a160418047_uts.util.buildDb
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
            val db = buildDb(getApplication())
            db.recipeDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    //val recipeLoadErrorLd= MutableLiveData<Boolean>()
    //val loadingld= MutableLiveData<Boolean>()
    fun fetch(id:Int) {
        launch {
            val db =buildDb(getApplication())
            recipeLd.value=db.recipeDao().selectRecipe(id)
        }
    }

}