package com.theme.Adminapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.theme.Adminapp.ClickInterface
import com.theme.Adminapp.ClickType
import com.theme.Adminapp.R
import com.theme.Adminapp.databinding.CategoryListItemBinding
import com.theme.Adminapp.CategoryModel


class CategoriesAdapter(var context: Context, var arrayList: ArrayList<CategoryModel>, var clicklistener: ClickInterface):RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    class ViewHolder(var binding: CategoryListItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(categoriesModel: CategoryModel, position: Int, clicklistener: ClickInterface, imageView: ImageView){
            binding.categoriesModel=categoriesModel
            binding.position=position
            binding.clickListener=clicklistener
            binding.imgDelete.setOnClickListener {
                clicklistener.onClick(position, ClickType.Delete)
            }
            binding.imgCandle.setOnClickListener {
                clicklistener.onClick(position, ClickType.img)
            }
            binding.tvsubcat.setOnClickListener {
                clicklistener.onClick(position, ClickType.AddSub)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding=CategoryListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            binding.tvcategory.setText(arrayList[position].categoryName)

            Glide
                .with(context)
                .load(arrayList[position].categoryImgUri)
                .centerCrop()
                .placeholder(R.drawable.candle)
                .into(binding.imgCandle)

//            binding.imgCandle.setImageURI(Uri.parse(arrayList[position].categoryImgUri))
            bindData(arrayList[position],position,clicklistener,binding.imgCandle)
//            imgset.setImage(position,binding.imgCandle)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

//    interface imageSetting {
//        fun setImage(position: Int,imageView: ImageView)
//    }
}