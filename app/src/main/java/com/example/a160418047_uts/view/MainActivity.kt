package com.example.a160418047_uts.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.a160418047_uts.R
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.Reward
import com.example.a160418047_uts.model.User
import com.example.a160418047_uts.viewmodel.RewardDetailViewModel
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import com.example.a160418047_uts.viewmodel.profilDetailViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController
        //NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)
       // bottomNav.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)
        val pref=this?.getSharedPreferences("USER", Context.MODE_PRIVATE);
        if(pref.getString("notfirst","")==""){
            val pic="https://www.detectiveconanworld.com/wiki/images/thumb/0/00/Conan_Edogawa_Profile.png/275px-Conan_Edogawa_Profile.png"
            val u1=User("albert","albert","Banjarmasin,23 juni 2000","08513256468",pic,"albert")
            val u2= User("test","test","Banjarmasin,23 juni 2000","08513256468",pic,"test")
            ViewModelProvider(this).get(profilDetailViewModel::class.java).addUser(listOf(u2,u1))
            var recipe= Recipe(nama = "nasi Goreng","nasi","digoreng","https://awsimages.detik.net.id/community/media/visual/2021/08/25/resep-nasi-goreng-sosis-ala-warung-bhakti_43.jpeg?w=700&q=90","Rice",0)
            var recipe2= Recipe(nama = "nasi Goreng 2","nasi","digoreng","https://awsimages.detik.net.id/community/media/visual/2021/08/25/resep-nasi-goreng-sosis-ala-warung-bhakti_43.jpeg?w=700&q=90","Rice",1)

            var list= listOf(recipe,recipe2)
            ViewModelProvider(this).get(itemRecipeDetailViewModel::class.java).addRecipe(list)
            var Reward1= Reward("VIP 3 days","Recipe Priority for 3 day",5)
            var Reward2= Reward("Vip 5 days","recipe priority for 5 days",3)
             var list2= listOf(Reward1,Reward2)
            ViewModelProvider(this).get(RewardDetailViewModel::class.java).addReward(list2)

            pref.edit(){
                putString("notfirst","ok").commit()
            }
            Toast.makeText(this, "DB Berhasil ditambah", Toast.LENGTH_SHORT).show()
        }
        if(pref.getString("uid","")==""){
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }





    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout)||super.onSupportNavigateUp()
    }

}