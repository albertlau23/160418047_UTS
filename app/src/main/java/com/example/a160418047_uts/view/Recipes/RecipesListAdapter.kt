package com.example.a160418047_uts.view.Recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.RecipesListItemBinding
import com.example.a160418047_uts.model.ButtonDetailClickListener
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.util.loadImage
import kotlinx.android.synthetic.main.recipes_list_item.view.*

class RecipesListAdapter(val recipesList:ArrayList<Recipe>):
    RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder>(),ButtonDetailClickListener {
    class RecipeViewHolder(var view:RecipesListItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        val inflater=LayoutInflater.from(parent.context)
        val view= DataBindingUtil.inflate<RecipesListItemBinding>(inflater,R.layout.recipes_list_item,parent,false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

//        holder.view.txtResepName.text=recipesList[position].nama
//        holder.view.imgResepList.loadImage(recipesList[position].url,holder.view.resepProgressError)
        holder.view.recipes=recipesList[position]
        holder.view.listener=this
//        holder.view.btnDetailResep.setOnClickListener {
//

//        }
        //holder.view.imgResepList
    }

    override fun getItemCount(): Int {
       // TODO("Not yet implemented")
        return recipesList.size
    }
    fun updateRecipes(newReipes:List<Recipe>){
        recipesList.clear()
        recipesList.addAll(newReipes)
        notifyDataSetChanged()

    }

    override fun onButtonDetailClick(v: View) {
        val action= RecipesListFragmentDirections.actionResepDetail( v.tag.toString().toInt());
        Navigation.findNavController(v).navigate(action)
    }
}