package com.example.a160418047_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.RecipeDatabase
import com.example.a160418047_uts.model.User
import com.example.a160418047_uts.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class profilDetailViewModel(application: Application):AndroidViewModel(application),
    CoroutineScope {
    val profilLd= MutableLiveData<User>()
    //val recipeLoadErrorLd= MutableLiveData<Boolean>()
    //val loadingld= MutableLiveData<Boolean>()
    private val job= Job();
    fun addUser(list:List<User>) {
        launch {
            val db = buildDb(getApplication())
            db.userDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    //val recipeLoadErrorLd= MutableLiveData<Boolean>()
    //val loadingld= MutableLiveData<Boolean>()
    fun fetch(id:String) {
        launch {
            val db = buildDb(getApplication())
            profilLd.value=db.userDao().viewUser(id)
        }


    }
    fun login(id:String,pass:String):String {
        launch {
            val db = buildDb(getApplication())
            profilLd.value=db.userDao().selectUser(id,pass)
        }
        if (profilLd.value?.username!=id){
            return "user tidak ditemukan"
        }else{
            return profilLd.value?.uuid.toString()
        }

    }

}