package com.example.a160418047_uts.view.Recipes

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentRecipesDetailBinding
import com.example.a160418047_uts.databinding.FragmentRecipesListBinding
import com.example.a160418047_uts.model.FABTambahClickListener
import com.example.a160418047_uts.viewmodel.listRecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipes_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class RecipesListFragment : Fragment(),FABTambahClickListener {
    // TODO: Rename and change types of parameters

    private lateinit var viewModel:listRecipeViewModel
    private val recipelistAdapter = RecipesListAdapter(arrayListOf())
    lateinit var  view:FragmentRecipesListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view= DataBindingUtil.inflate<FragmentRecipesListBinding>(inflater,R.layout.fragment_recipes_list, container, false)
        return view.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(listRecipeViewModel::class.java)
        viewModel.refresh()
        recViewResep.layoutManager = LinearLayoutManager(context)
        recViewResep.adapter = recipelistAdapter
        observeViewModel()

    }
    fun observeViewModel() {

        viewModel.recipeLd.observe(viewLifecycleOwner, Observer {
            recipelistAdapter.updateRecipes(it)
            view.listener=this
            if(it.isEmpty()){
                txtErrorResep.visibility = View.VISIBLE
                resepLoad.visibility = View.VISIBLE
            }else{
                txtErrorResep.visibility = View.GONE
                resepLoad.visibility = View.GONE
            }
        })
//        viewModel.recipeLoadErrorLd.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                txtErrorResep.visibility = View.VISIBLE
//            } else {
//                txtErrorResep.visibility = View.GONE
//            }
//        })
//        viewModel.loadingld.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                recViewResep.visibility = View.GONE
//                resepLoad.visibility = View.VISIBLE
//            } else {
//                recViewResep.visibility = View.VISIBLE
//                resepLoad.visibility = View.GONE
//            }
//        })

    }

    override fun onFABTambahClick(v: View) {
        val action= RecipesListFragmentDirections.actionRecipesListFragmentToRecipesAddFragment();
        Navigation.findNavController(v).navigate(action)
    }


}