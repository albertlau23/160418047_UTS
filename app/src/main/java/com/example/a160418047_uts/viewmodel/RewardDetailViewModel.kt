package com.example.a160418047_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.a160418047_uts.model.RecipeDatabase
import com.example.a160418047_uts.model.Reward
import com.example.a160418047_uts.model.User
import com.example.a160418047_uts.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RewardDetailViewModel(application: Application): AndroidViewModel(application),
    CoroutineScope {
    private val job= Job();
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    val rewardLd= MutableLiveData<Reward>()


    fun fetch(id:String){
        launch {
            val db = buildDb(getApplication())
            rewardLd.value=db.rewardDao().viewReward(id)

        }

    }fun addReward(list:List<Reward>) {
        launch {
            val db = buildDb(getApplication())
            db.rewardDao().insertAll(*list.toTypedArray())
        }
    }
}