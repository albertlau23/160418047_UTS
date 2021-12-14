package com.example.a160418047_uts.view.Profil

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentProfilBinding
import com.example.a160418047_uts.databinding.FragmentProfilDetailBinding
import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.viewmodel.profilDetailViewModel
import com.example.a160418047_uts.viewmodel.profilViewModel
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var  view: FragmentProfilDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view= DataBindingUtil.inflate<FragmentProfilDetailBinding>(inflater,R.layout.fragment_profil_detail, container, false)
        return view.root
    }

    private lateinit var viewModel: profilDetailViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref=activity?.getSharedPreferences("USER", Context.MODE_PRIVATE);

        var uname=pref?.getString("uid","");
        viewModel = ViewModelProvider(this).get(profilDetailViewModel::class.java)
        viewModel.fetch(uname!!);
        observeViewModel()


    }
    fun observeViewModel() {
        viewModel.profilLd.observe(viewLifecycleOwner, Observer {
            view.user=it

        })

    }
}