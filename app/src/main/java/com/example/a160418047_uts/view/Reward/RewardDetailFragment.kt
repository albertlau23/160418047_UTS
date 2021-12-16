package com.example.a160418047_uts.view.Reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentRecipesDetailBinding
import com.example.a160418047_uts.databinding.FragmentRewardDetailBinding
import com.example.a160418047_uts.view.Recipes.RecipesDetailFragmentArgs
import com.example.a160418047_uts.viewmodel.RewardDetailViewModel
import com.example.a160418047_uts.viewmodel.RewardViewModel
import kotlinx.android.synthetic.main.fragment_reward_detail.*


class RewardDetailFragment : Fragment() {
   private lateinit var viewModel: RewardDetailViewModel
    lateinit var view: FragmentRewardDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = DataBindingUtil.inflate<FragmentRewardDetailBinding>(
            inflater,
            R.layout.fragment_reward_detail,
            container,
            false
        )
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val id = RewardDetailFragmentArgs.fromBundle(requireArguments()).id;
            Toast.makeText((context), id.toString(), Toast.LENGTH_SHORT).show()
            viewModel = ViewModelProvider(this).get(RewardDetailViewModel::class.java)
            viewModel.fetch(id.toString())
            observeviewmodel()
        }
    }
    fun observeviewmodel(){
        viewModel.rewardLd.observe(viewLifecycleOwner, Observer{
            view.reward=it


        })
    }
}