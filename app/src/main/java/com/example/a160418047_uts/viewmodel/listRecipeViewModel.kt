package com.example.a160418047_uts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418047_uts.model.Recipe

class listRecipeViewModel: ViewModel() {
    val recipeLd= MutableLiveData<List<Recipe>>()
    val recipeLoadErrorLd=MutableLiveData<Boolean>()
    val loadingld=MutableLiveData<Boolean>()
    fun refresh(){
        //data
        var recipes1=Recipe("recipes#1","Nasi Goreng spesial", arrayOf("3 sendok nasi","mentega","1 butir telur"),
            arrayOf("1.panaskan mentega","2.goreng telur hingga hancur","3.masukan nasi dan aduk rata"),"https://awsimages.detik.net.id/community/media/visual/2021/08/25/resep-nasi-goreng-sosis-ala-warung-bhakti_43.jpeg?w=700&q=90")
        var recipes2=Recipe("recipes#2","bakso", arrayOf("1 bungkus sogood meat ball","air secukupnya","2 sdt garam"),
            arrayOf("1.panaskan air hingga mendidih","2.masukan sogood meat ball","3.tambahkan garam dan aduk hingga larut"),"https://www.langsungenak.com/wp-content/uploads/2016/05/Resep-Bakso-Andalan-by-Fanny-Niel-Jensen.jpg")
        //till here
        val recipelist:ArrayList<Recipe> = arrayListOf(recipes1,recipes2);
        recipeLd.value=recipelist
        recipeLoadErrorLd.value=false;
        loadingld.value=false
    }
}