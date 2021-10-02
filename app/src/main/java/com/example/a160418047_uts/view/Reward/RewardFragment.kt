package com.example.a160418047_uts.view.Reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418047_uts.R
import com.example.a160418047_uts.view.Recipes.RecipesListAdapter
import com.example.a160418047_uts.viewmodel.RewardViewModel
import kotlinx.android.synthetic.main.fragment_recipes_list.*
import kotlinx.android.synthetic.main.fragment_reward.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class RewardFragment : Fragment() {
   private lateinit var viewmodel:RewardViewModel
    private val rewardAdapter = rewardAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reward, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel= ViewModelProvider(this).get(RewardViewModel::class.java)
        viewmodel.refresh()
        RecViewReward.layoutManager=LinearLayoutManager(context)
        RecViewReward.adapter=rewardAdapter
        observeViewModel()

    }
    fun observeViewModel(){
        viewmodel.rewardLd.observe(viewLifecycleOwner, Observer {
            rewardAdapter.upadateReward(it)
        })
        viewmodel.recipeLoadErrorLd.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtError.visibility = View.VISIBLE
            } else {
                txtError.visibility = View.GONE
            }
        })
        viewmodel.loadingld.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                RecViewReward.visibility = View.GONE
                loadReward.visibility = View.VISIBLE
            } else {
                RecViewReward.visibility = View.VISIBLE
                loadReward.visibility = View.GONE
            }
        })
    }
}