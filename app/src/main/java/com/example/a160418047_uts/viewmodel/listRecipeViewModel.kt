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

class listRecipeViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {
    val recipeLd = MutableLiveData<List<Recipe>>()
    val recipeLoadErrorLd = MutableLiveData<Boolean>()
    val loadingld = MutableLiveData<Boolean>()
    private var jab = Job()
    override val coroutineContext: CoroutineContext
        get() = jab + Dispatchers.Main

    fun refresh() {
        loadingld.value = true
        recipeLoadErrorLd.value = false
        launch {
            val db = buildDb(getApplication())

            recipeLd.value = db.recipeDao().selectAllRecipe()
            print("resep:" + recipeLd)
        }

    }

    fun clearTask(recipe: Recipe) {
        launch {
            val db = buildDb(getApplication())
            db.recipeDao().deleteRecipe(recipe)

            recipeLd.value = db.recipeDao().selectAllRecipe()

        }


        //data

//        val recipelist:ArrayList<Recipe> = arrayListOf();
//        recipeLd.value=recipelist
//        recipeLoadErrorLd.value=false;
//        loadingld.value=false
    }
}