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
import kotlinx.android.synthetic.main.fragment_recipes_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class RecipesListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var viewModel:listRecipeViewModel
    private val recipelistAdapter = RecipesListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(listRecipeViewModel::class.java)
        viewModel.refresh()
        recViewResep.layoutManager = LinearLayoutManager(context)
        recViewResep.adapter = recipelistAdapter
        observeViewModel()

//        val pref=activity?.getSharedPreferences("user", 0)?:return
//        val uname=pref.getString("user_uname","Guest")
//        Toast.makeText(context, uname, Toast.LENGTH_SHORT).show()
    }
    fun observeViewModel() {
        viewModel.recipeLd.observe(viewLifecycleOwner, Observer {
            recipelistAdapter.updateRecipes(it)
        })
        viewModel.recipeLoadErrorLd.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorResep.visibility = View.VISIBLE
            } else {
                txtErrorResep.visibility = View.GONE
            }
        })
        viewModel.loadingld.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recViewResep.visibility = View.GONE
                resepLoad.visibility = View.VISIBLE
            } else {
                recViewResep.visibility = View.VISIBLE
                resepLoad.visibility = View.GONE
            }
        })

    }



}