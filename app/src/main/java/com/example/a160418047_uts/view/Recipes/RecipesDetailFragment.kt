package com.example.a160418047_uts.view.Recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418047_uts.R
import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import kotlinx.android.synthetic.main.fragment_recipes_detail.*



class RecipesDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel:itemRecipeDetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_detail, container, false)
    }
    fun observeViewModel() {
        viewModel.recipeLd.observe(viewLifecycleOwner, Observer {
           txtNamaDetail.setText(it.nama)
            txtcaraDetail.setText("cara:\n"+it.cara!!.joinToString(separator = "\n") {it})
            txtbahanDetail.setText("bahan:\n"+it.bahan!!.joinToString(separator = "\n") {it})
            imgResepDetail.loadImage(it.url,errorDetailImg)
        })

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val name= RecipesDetailFragmentArgs.fromBundle(requireArguments()).nama;
            val bahan= RecipesDetailFragmentArgs.fromBundle(requireArguments()).bahan;
            val cara= RecipesDetailFragmentArgs.fromBundle(requireArguments()).cara;
            val url= RecipesDetailFragmentArgs.fromBundle(requireArguments()).imgurl;
            viewModel = ViewModelProvider(this).get(itemRecipeDetailViewModel::class.java)
            viewModel.fetch(name!!,bahan!!,cara!!,url!!);
            observeViewModel()


        }
    }
}