package com.example.a160418047_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418047_uts.model.Recipe

class myRecipesViewModel:ViewModel() {
    val recipeLd= MutableLiveData<List<Recipe>>()
    val recipeLoadErrorLd= MutableLiveData<Boolean>()
    val loadingld= MutableLiveData<Boolean>()
    fun refresh(){
        //data
        var recipes1= Recipe("recipes#1","Nasi Goreng spesial", arrayOf("3 sendok nasi","mentega","1 butir telur"),
            arrayOf("1.panaskan mentega","2.goreng telur hingga hancur","3.masukan nasi dan aduk rata"),"https://awsimages.detik.net.id/community/media/visual/2021/08/25/resep-nasi-goreng-sosis-ala-warung-bhakti_43.jpeg?w=700&q=90")

        val recipelist:ArrayList<Recipe> = arrayListOf(recipes1);
        recipeLd.value=recipelist
        recipeLoadErrorLd.value=false;
        loadingld.value=false
    }
}