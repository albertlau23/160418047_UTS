package com.example.a160418047_uts.view.Recipes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.FragmentRecipesAddBinding
import com.example.a160418047_uts.databinding.FragmentRecipesDetailBinding
import com.example.a160418047_uts.ml.Model2
import com.example.a160418047_uts.model.ButtonTambahClickListener
import com.example.a160418047_uts.model.Recipe

import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.viewmodel.itemRecipeDetailViewModel
import com.example.a160418047_uts.viewmodel.myRecipesViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recipes_add.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.DequantizeOp
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [RecipesAddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipesAddFragment : Fragment(), ButtonTambahClickListener {
    private lateinit var viewModel: itemRecipeDetailViewModel
    lateinit var _view: FragmentRecipesAddBinding


    var uuid = 0




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(itemRecipeDetailViewModel::class.java)
        val pref = activity?.getSharedPreferences("USER", Context.MODE_PRIVATE);
        uuid = pref?.getString("uuid", "").toString().toInt()
        _view.recipes=Recipe("","","","","",0)
        _view.listener = this

//        btnTambah.setOnClickListener {
//
//            var list= listOf(recipe)
//            viewModel.addRecipe(list)
//            Navigation.findNavController(it).popBackStack()
//
//            Toast.makeText(context, _view.recipes?.nama.toString(), Toast.LENGTH_SHORT).show()
//        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _view = DataBindingUtil.inflate<FragmentRecipesAddBinding>(
            inflater,
            R.layout.fragment_recipes_add,
            container,
            false
        )
        return _view.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    override fun onButtonTambahClick(v: View) {
        var recipe=Recipe(_view.recipes?.nama,_view.recipes?.bahan,_view.recipes?.cara,_view.recipes?.url,"makanan dasar",uuid)

        var list= listOf(recipe)
        viewModel.addRecipe(list)
        Navigation.findNavController(v).popBackStack()

    }


}