package com.example.a160418047_uts.view.Recipes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentRecipesDetailBinding
import com.example.a160418047_uts.ml.Model2

import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recipes_detail.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.DequantizeOp
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.common.ops.QuantizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder


class RecipesDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel: itemRecipeDetailViewModel
    lateinit var view: FragmentRecipesDetailBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = DataBindingUtil.inflate<FragmentRecipesDetailBinding>(
            inflater,
            R.layout.fragment_recipes_detail,
            container,
            false
        )
        return view.root
    }

    fun observeViewModel() {

        viewModel.recipeLd.observe(viewLifecycleOwner, Observer {
            it.cara = "cara:\n" + it.cara
            it.bahan = "bahan:\n" + it.bahan
            view.recipes = it



        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val id = RecipesDetailFragmentArgs.fromBundle(requireArguments()).id;
            viewModel = ViewModelProvider(this).get(itemRecipeDetailViewModel::class.java)
            viewModel.fetch(id);
            observeViewModel()


        }
    }




}