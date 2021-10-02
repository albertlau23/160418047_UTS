package com.example.a160418047_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418047_uts.model.Reward

class RewardDetailViewModel:ViewModel() {
    val rewardLd= MutableLiveData<Reward>()


    fun fetch(){
        var Reward1=Reward("VIP 3 days","Recipe Priority for 3 day",5)
        rewardLd.value=Reward1

    }
}