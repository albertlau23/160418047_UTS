package com.example.a160418047_uts.view.Reward

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418047_uts.R
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.model.Reward
import com.example.a160418047_uts.view.Recipes.RecipesListAdapter
import kotlinx.android.synthetic.main.fragment_reward_detail.view.*
import kotlinx.android.synthetic.main.reward_item.view.*

class rewardAdapter(val rewards:ArrayList<Reward>):
    RecyclerView.Adapter<rewardAdapter.RewardViewHolder>() {
    class RewardViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.reward_item,parent,false)
        return RewardViewHolder(view)

    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        holder.view.txtRewardNameMain.setText(rewards[position].nama)
        holder.view.txtQuantityMain.setText(rewards[position].quatity.toString()+" x")
        holder.view.btnDetail.setOnClickListener {
            val act=RewardFragmentDirections.actionRewardFragmentToRewardDetailFragment()
            Navigation.findNavController(it).navigate(act)
        }
    }

    override fun getItemCount(): Int {
        return  rewards.size
    }
    fun upadateReward(newReward:List<Reward>){
        rewards.clear()
        rewards.addAll(newReward)
        notifyDataSetChanged()

    }
}