package com.example.a160418047_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418047_uts.model.Recipe

class itemRecipeDetailViewModel:ViewModel() {
    val recipeLd= MutableLiveData<Recipe>()
    //val recipeLoadErrorLd= MutableLiveData<Boolean>()
    //val loadingld= MutableLiveData<Boolean>()
    fun fetch(nama:String,bahan:Array<String>,cara:Array<String>,url:String) {
        val recipe = Recipe("recipes",nama,bahan,cara,url)
        recipeLd.value = recipe
    }

}