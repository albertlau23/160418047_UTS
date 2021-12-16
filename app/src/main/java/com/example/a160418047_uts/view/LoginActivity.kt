package com.example.a160418047_uts.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentLoginBinding
import com.example.a160418047_uts.databinding.FragmentRecipesAddBinding
import com.example.a160418047_uts.model.ButtonLoginListener
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.RecipeDatabase
import com.example.a160418047_uts.model.User
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import com.example.a160418047_uts.viewmodel.profilDetailViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(),ButtonLoginListener  {
    lateinit var  _view: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _view= FragmentLoginBinding.inflate(layoutInflater)
        setContentView(_view.root)
        _view.listener=this




//        Toast.makeText(this, pref.getString("uid","tidak ada"), Toast.LENGTH_SHORT).show()

    }

    override fun onButtonLogin(v: View) {
        val pref=this?.getSharedPreferences("USER",Context.MODE_PRIVATE);
        if(_view.user?.username!=""){
//                ViewModelProvider(this).get(profilDetailViewModel::class.java).(users)
            val stat=ViewModelProvider(this).get(profilDetailViewModel::class.java).login(loginUname.text.toString(),loginUpass.text.toString())
            Toast.makeText(this, stat, Toast.LENGTH_SHORT).show()
            if(stat!="user tidak ditemukan"){
                Toast.makeText(this, "Login berhasi", Toast.LENGTH_SHORT).show()
                pref.edit{
                    putString("uid",loginUname.text.toString()).commit()
                    putString("uuid",stat).commit()

                }
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()

            }

        }else{
            Toast.makeText(this, "user tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }


}