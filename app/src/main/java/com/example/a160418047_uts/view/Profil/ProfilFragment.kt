package com.example.a160418047_uts.view.Profil

import android.content.Context
import android.content.SharedPreferences
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418047_uts.R
import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.view.Recipes.MyRecipesFragmentDirections
import com.example.a160418047_uts.view.Recipes.RecipesDetailFragmentArgs
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import com.example.a160418047_uts.viewmodel.profilViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil_detail.*
import kotlinx.android.synthetic.main.fragment_recipes_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel:profilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref=activity?.getSharedPreferences("user",Context.MODE_PRIVATE)?:return
        val uname=pref.getString("user_uname","Guest")?:"Guest"
//           if(uname!="Guest") {
               Toast.makeText(context, uname, Toast.LENGTH_SHORT).show()
               viewModel = ViewModelProvider(this).get(profilViewModel::class.java)
               viewModel.fetch(uname!!);
               observeViewModel()
//           }else{
//               txtNamaProf.setText("Guest")
//               btnLogout.setText("LOGIN")
//               imgProfil.setImageResource(R.drawable.ic_baseline_person_24)
//               btnDetailProf.visibility=View.GONE
//               loadImgProf.visibility=View.GONE
//           }
        btnDetailProf.setOnClickListener {
            val action= ProfilFragmentDirections.actionProfilFragmentToProfilDetailFragment(uname)
            Navigation.findNavController(it).navigate(action)
        }
//        btnLogout.setOnClickListener {
//            val action= ProfilFragmentDirections.actionItemProfilToLandingFragment()
//            Navigation.findNavController(it).navigate(action)
//        }

    }
    fun observeViewModel() {
        viewModel.profilLd.observe(viewLifecycleOwner, Observer {
            txtNamaProf.setText(it.nama)
            imgProfil.loadImage(it.imgurl,loadImgProf)
        })

    }


}