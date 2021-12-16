package com.example.a160418047_uts.view.Recipes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418047_uts.R
import com.example.a160418047_uts.databinding.RecipesListItemBinding
import com.example.a160418047_uts.ml.Model2
import com.example.a160418047_uts.model.ButtonDetailClickListener
import com.example.a160418047_uts.model.Recipe
import com.example.a160418047_uts.util.loadImage
import com.example.a160418047_uts.viewmodel.listRecipeViewModel
import com.example.a160418047_uts.viewmodel.myRecipesViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipes_list_item.view.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.DequantizeOp
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class MyRecipesListAdapter(val recipesList: ArrayList<Recipe>) :
    RecyclerView.Adapter<MyRecipesListAdapter.MyRecipesViewHolder>(), ButtonDetailClickListener {
    class MyRecipesViewHolder(var view: RecipesListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyRecipesListAdapter.MyRecipesViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecipesListItemBinding>(
            inflater,
            R.layout.recipes_list_item,
            parent,
            false
        )
        return MyRecipesListAdapter.MyRecipesViewHolder(view)
    }

    lateinit var ctx: Context
    var foodies = arrayOf<String>(
        "Bread",
        "Fried food",
        "Rice",
        "Seafood",
        "Dessert",
        "Egg",
        "Meat",
        "Dairy product",
        "Noodles-Pasta",
        "Soup",
        "Vegetable-Fruit"

    )

    override fun onBindViewHolder(holder: MyRecipesListAdapter.MyRecipesViewHolder, position: Int) {
        var max = 0
        val target = object : com.squareup.picasso.Target {

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {

                Log.e("done", "loading")

                var imageProcessor =
                    ImageProcessor.Builder()
                        .add(ResizeOp(100, 100, ResizeOp.ResizeMethod.BILINEAR))
                        .add(DequantizeOp(0f, 1 / 255.0f))
                        .add(NormalizeOp(0f, 1f))

                        .build()


                var resized = Bitmap.createScaledBitmap(bitmap!!, 100, 100, true)

                val model = Model2.newInstance(ctx)
                val inputFeature0 =
                    TensorBuffer.createFixedSize(intArrayOf(1, 100, 100, 3), DataType.FLOAT32)
                var tbuffer = TensorImage(DataType.FLOAT32)
//            tbuffer=TensorImage.fromBitmap(resized)
                tbuffer.load(resized)
                tbuffer = imageProcessor.process(tbuffer)


                var byteBuffer = tbuffer.buffer

                inputFeature0.loadBuffer(byteBuffer)


                val outputs = model.process(inputFeature0)
                val outputFeature = outputs.outputFeature0AsTensorBuffer

                var x = 0;
                for (i in outputFeature.floatArray) {

                    var y = foodies[x]
                    Log.e("hasil predik", "$y-$i")
                    x += 1;
                }
                max = getMax(outputFeature.floatArray)




                model?.close()
                recipesList[position].cat = foodies[max]
                if(recipesList[position].cat==foodies[max]){

                    holder.view.recipes = recipesList[position]
                }



                // loaded bitmap is here (bitmap)
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                Log.e("load", "loading")
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                Log.e("load", "error")
            }
        }
        Picasso.get().load(recipesList[position].url).into(target)
        holder.view.recipes = recipesList[position]

        holder.view.recipes = recipesList[position]
        holder.view.listener = this
        //holder.view.imgResepList
    }

    override fun getItemCount(): Int {
        // TODO("Not yet implemented")
        return recipesList.size
    }

    fun getMax(arr: FloatArray): Int {
        var idx = 0;
        var max = 0.0f
        for (i in 0..arr.count() - 1) {
            if (arr[i] >= max) {
                max = arr[i]
                idx = i
            }
        }
        return idx
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        ctx = recyclerView.context
    }

    fun updateRecipes(newReipes: List<Recipe>) {
        recipesList.clear()
        recipesList.addAll(newReipes)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = MyRecipesFragmentDirections.actionMyRecipesFragmentToRecipesDetailFragment(
            v.tag.toString().toInt()
        );
        Navigation.findNavController(v).navigate(action)
    }

}