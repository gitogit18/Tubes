package com.example.tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.tubes.ui.healtharticle.HealthArticleActivity

class MainMenuActivity : AppCompatActivity() {

    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        clickListener()

    }

    public fun clickListener(){
        var imageHealthArticles = findViewById<ImageView>(R.id.ivhealtharticles);

        imageHealthArticles.setOnClickListener {
            openHealthArticleActivity()
        }
    }

    public fun openHealthArticleActivity(){
        startActivity(Intent(this@MainMenuActivity, HealthArticleActivity::class.java))

    }

    public fun openSettingsActivity(){

    }
}