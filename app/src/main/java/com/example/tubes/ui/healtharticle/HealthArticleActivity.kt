package com.example.tubes.ui.healtharticle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tubes.R
import com.example.tubes.data.HealthArticleData
import com.example.tubes.databinding.ActivityHealthArticleBinding

class HealthArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHealthArticleBinding
    private val list = ArrayList<HealthArticleData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            list.addAll(getArticle())
            showRecylerView()

        }

    }
    private fun getArticle(): ArrayList<HealthArticleData> {
        val titles = resources.getStringArray(R.array.item_titles)
        val details = resources.getStringArray(R.array.item_details)
        val images = resources.obtainTypedArray(R.array.item_images)
        val listArticle = ArrayList<HealthArticleData>()

        for (i in titles.indices) {
            val article = HealthArticleData(details[i],images.getResourceId(i,-1),titles[i] )
            listArticle.add(article)
        }

        return listArticle
    }


    private fun showRecylerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = HealthArticleAdapter(list)
        binding.recyclerView.adapter = listArticleAdapter
    }

}