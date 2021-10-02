package com.example.a160418047_uts.view.Recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418047_uts.R
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.util.loadImage
import kotlinx.android.synthetic.main.recipes_list_item.view.*

class RecipesListAdapter(val recipesList:ArrayList<Recipe>):
    RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder>() {
    class RecipeViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        val inflater=LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.recipes_list_item,parent,false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.view.txtResepName.text=recipesList[position].nama
        holder.view.imgResepList.loadImage(recipesList[position].url,holder.view.resepProgressError)

        holder.view.btnDetailResep.setOnClickListener {

            val action= RecipesListFragmentDirections.actionResepDetail(recipesList[position].nama,recipesList[position].bahan,recipesList[position].cara,recipesList[position].url);
            Navigation.findNavController(it).navigate(action)
        }
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
}