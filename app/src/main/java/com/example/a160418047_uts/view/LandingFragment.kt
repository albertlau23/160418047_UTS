package com.example.a160418047_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a160418047_uts.R
import kotlinx.android.synthetic.main.fragment_landing.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LandingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LandingFragment : Fragment() {
    // TODO: Rename and change types of parameters




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btnWelcomeLogin.setOnClickListener {
//            val act=LandingFragmentDirections.actionLandingFragmentToLogin()
//            Navigation.findNavController(it).navigate(act)
//        }
//        btnWelcomeReg.setOnClickListener {
//            val act=LandingFragmentDirections.actionLandingFragmentToRegisterFragment()
//            Navigation.findNavController(it).navigate(act)
//        }
    }


}