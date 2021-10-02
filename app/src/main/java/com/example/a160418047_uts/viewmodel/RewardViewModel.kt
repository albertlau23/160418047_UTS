package com.example.a160418047_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.Reward

class RewardViewModel:ViewModel (){
    val rewardLd= MutableLiveData<List<Reward>>()
    val recipeLoadErrorLd= MutableLiveData<Boolean>()
    val loadingld= MutableLiveData<Boolean>()

    fun refresh(){
        var Reward1=Reward("VIP 3 days","Recipe Priority for 3 day",5)
        var Reward2=Reward("Vip 5 days","recipe priority for 5 days",3)
        val rewardList:ArrayList<Reward> = arrayListOf(Reward1,Reward2);
        rewardLd.value=rewardList
        recipeLoadErrorLd.value=false;
        loadingld.value=false
    }
}