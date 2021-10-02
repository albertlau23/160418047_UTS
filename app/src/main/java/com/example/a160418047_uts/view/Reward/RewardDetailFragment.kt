package com.example.a160418047_uts.view.Reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a160418047_uts.R
import com.example.a160418047_uts.viewmodel.RewardDetailViewModel
import com.example.a160418047_uts.viewmodel.RewardViewModel
import kotlinx.android.synthetic.main.fragment_reward_detail.*


class RewardDetailFragment : Fragment() {
   private lateinit var viewModel: RewardDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reward_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(RewardDetailViewModel::class.java)
        viewModel.fetch()
        observeviewmodel()
    }
    fun observeviewmodel(){
        viewModel.rewardLd.observe(viewLifecycleOwner, Observer{
            txtRewardName.text=it.nama
            txtQuantity.text="sisa: "+it.quatity.toString()+" x"
            txtInfo.text="keterangan: "+it.info
        })
    }
}