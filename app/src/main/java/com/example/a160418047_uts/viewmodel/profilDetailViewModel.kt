package com.example.a160418047_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.User

class profilDetailViewModel:ViewModel() {
    val profilLd= MutableLiveData<User>()
    //val recipeLoadErrorLd= MutableLiveData<Boolean>()
    //val loadingld= MutableLiveData<Boolean>()
    fun fetch(id:String) {
        val userCurr = User(id,"albert","23 februari 1973","081212345678","https://www.detectiveconanworld.com/wiki/images/thumb/0/00/Conan_Edogawa_Profile.png/275px-Conan_Edogawa_Profile.png","1")
        profilLd.value = userCurr
    }

}