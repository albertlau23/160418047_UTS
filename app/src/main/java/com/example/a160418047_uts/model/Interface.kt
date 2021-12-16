package com.example.a160418047_uts.model

import android.view.View

interface ButtonDetailClickListener {
    fun onButtonDetailClick(v:View)
}
interface ButtonTambahClickListener {
    fun onButtonTambahClick(v:View)
}
interface FABTambahClickListener {
    fun onFABTambahClick(v:View)
}
interface  ButtonLogOutListener{
    fun onButtonLogout(v:View)
}
interface  ButtonLoginListener{
    fun  onButtonLogin(v: View)
}