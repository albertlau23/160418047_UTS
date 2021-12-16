package com.example.a160418047_uts.view.Reward

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.RecipesListItemBinding
import com.example.a160418047_uts.databinding.RewardItemBinding
import com.example.a160418047_uts.model.ButtonDetailClickListener
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.Reward
import com.example.a160418047_uts.view.Recipes.RecipesListAdapter
import com.example.a160418047_uts.view.Recipes.RecipesListFragmentDirections
import kotlinx.android.synthetic.main.fragment_reward_detail.view.*
import kotlinx.android.synthetic.main.reward_item.view.*

class rewardAdapter(val rewards:ArrayList<Reward>):
    RecyclerView.Adapter<rewardAdapter.RewardViewHolder>(), ButtonDetailClickListener {
    class RewardViewHolder(var view:RewardItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view= DataBindingUtil.inflate<RewardItemBinding>(inflater,R.layout.reward_item,parent,false)
        return RewardViewHolder(view)

    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        holder.view.reward=rewards[position]

        holder.view.listener=this
    }

    override fun getItemCount(): Int {
        return  rewards.size
    }
    fun upadateReward(newReward:List<Reward>){
        rewards.clear()
        rewards.addAll(newReward)
        notifyDataSetChanged()

    }

    override fun onButtonDetailClick(v: View) {

        val action= RewardFragmentDirections.actionRewardFragmentToRewardDetailFragment(v.tag.toString());
        Navigation.findNavController(v).navigate(action)
    }
}