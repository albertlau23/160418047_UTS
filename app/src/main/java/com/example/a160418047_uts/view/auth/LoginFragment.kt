package com.example.a160418047_uts.view.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.navigation.Navigation
import com.example.a160418047_uts.R
import kotlinx.android.synthetic.main.fragment_login.*


class Login : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener {
            if(loginUname.text.toString()!=""){
//                val pref=activity?.getSharedPreferences("user", 0)
//                pref?.edit {
//                    putString("user_username",loginUname.text.toString()).commit()
//
//                }




               // var act=LoginDirections.actionLoginToRecipesListFragment()
              //  Navigation.findNavController(it).navigate(act)
            }else{
            }

        }
//        btnToRegis.setOnClickListener {
//            var act=LoginDirections.actionLoginToRegisterFragment()
//            Navigation.findNavController(it).navigate(act)
//        }
    }
}