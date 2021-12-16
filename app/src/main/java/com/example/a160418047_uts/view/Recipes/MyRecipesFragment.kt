package com.example.a160418047_uts.view.Recipes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418047_uts.R
import com.example.a160418047_uts.viewmodel.listRecipeViewModel
import com.example.a160418047_uts.viewmodel.myRecipesViewModel
import com.example.a160418047_uts.viewmodel.profilViewModel
import kotlinx.android.synthetic.main.fragment_my_recipes.*
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_recipes_list.*


class MyRecipesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel: myRecipesViewModel
    private var myrecipesAdapter = MyRecipesListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref=activity?.getSharedPreferences("USER", Context.MODE_PRIVATE);
        var userloged=pref?.getString("uid","")
        viewModel = ViewModelProvider(this).get(myRecipesViewModel::class.java)
        viewModel.refresh(userloged!!)
        myRecipesRecView.layoutManager = LinearLayoutManager(context)
        myRecipesRecView.adapter = myrecipesAdapter
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.recipeLd.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it.count().toString(), Toast.LENGTH_SHORT).show()
            myrecipesAdapter.updateRecipes(it)
            if(it.isEmpty()){
                myError.visibility = View.VISIBLE
                loadMyRecipes.visibility = View.VISIBLE
            }else{
                myRecipesRecView.visibility = View.VISIBLE
                myError.visibility = View.GONE
                loadMyRecipes.visibility = View.GONE
            }
            //Toast.makeText(context, "ok", Toas.t.LENGTH_SHORT).show()

        })
//        viewModel.recipeLoadErrorLd.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                myError.visibility = View.VISIBLE
//            } else {
//                myError.visibility = View.GONE
//            }
//        })
//        viewModel.loadingld.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                myRecipesRecView.visibility = View.GONE
//                loadMyRecipes.visibility = View.VISIBLE
//            } else {
//                loadMyRecipes.visibility = View.GONE
//                myRecipesRecView.visibility = View.VISIBLE
//            }
//        })

    }


}