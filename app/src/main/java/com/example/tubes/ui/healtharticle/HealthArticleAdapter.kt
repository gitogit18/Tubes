package com.example.tubes.ui.healtharticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tubes.data.HealthArticleData
import com.example.tubes.databinding.ItemArticleBinding

class HealthArticleAdapter(private val article: ArrayList<HealthArticleData>): RecyclerView.Adapter<HealthArticleAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemArticleBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = article.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = article[position]

        holder.apply {
            binding.apply {
                tvArticleDetails.text = currentItem.itemDetails
                tvArticleTitle.text = currentItem.itemTitles
                imgArticle.setImageResource(currentItem.itemImages)
            }
        }
    }


}