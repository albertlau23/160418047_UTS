package com.example.a160418047_uts.view.Profil

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentProfilBinding
import com.example.a160418047_uts.databinding.FragmentRecipesDetailBinding
import com.example.a160418047_uts.model.ButtonDetailClickListener
import com.example.a160418047_uts.model.ButtonLogOutListener
import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.view.LoginActivity
import com.example.a160418047_uts.view.Recipes.MyRecipesFragmentDirections
import com.example.a160418047_uts.view.Recipes.RecipesDetailFragmentArgs
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import com.example.a160418047_uts.viewmodel.profilDetailViewModel
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
class ProfilFragment : Fragment(),ButtonDetailClickListener,ButtonLogOutListener {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel:profilViewModel
    lateinit var  view: FragmentProfilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view= DataBindingUtil.inflate<FragmentProfilBinding>(inflater,R.layout.fragment_profil, container, false)
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref=activity?.getSharedPreferences("USER", Context.MODE_PRIVATE);


        var uname=pref?.getString("uid","");
        uname.let {
            viewModel = ViewModelProvider(this).get(profilViewModel::class.java)
            viewModel.fetch(uname?:"")
            observeViewModel()
        }




    }
    fun observeViewModel() {
        view.logoutlistener=this
        view.listener=this
        viewModel.profilLd.observe(viewLifecycleOwner, Observer {
            view.user=it
        })

    }

    override fun onButtonDetailClick(v: View) {
        val action= ProfilFragmentDirections.actionProfilFragmentToProfilDetailFragment()
        Navigation.findNavController(v).navigate(action)
    }

    override fun onButtonLogout(v: View) {
        val intent= Intent(context, LoginActivity::class.java)
        val pref=activity?.getSharedPreferences("USER", Context.MODE_PRIVATE);
        pref?.edit {
            remove("uid").commit()
            remove("uuid").commit()
        }
        startActivity(intent)
        activity?.finish()
    }


}