package com.example.a160418047_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.RecipeDatabase
import com.example.a160418047_uts.model.Reward
import com.example.a160418047_uts.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RewardViewModel(application: Application) : AndroidViewModel(application),CoroutineScope{
    val rewardLd= MutableLiveData<List<Reward>>()
    val recipeLoadErrorLd= MutableLiveData<Boolean>()
    val loadingld= MutableLiveData<Boolean>()
    private var jab = Job()
    override val coroutineContext: CoroutineContext
        get() = jab + Dispatchers.Main

    fun refresh() {
        loadingld.value = true
        recipeLoadErrorLd.value = false
        launch {
            val db = buildDb(getApplication())

            rewardLd.value = db.rewardDao().selectAllReward()


        }

    }
}