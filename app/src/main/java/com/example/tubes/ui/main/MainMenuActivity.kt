package com.example.tubes.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.tubes.R
import com.example.tubes.databinding.ActivityMainMenuBinding
import com.example.tubes.ui.askica.AskIcaActivity
import com.example.tubes.ui.bmicalculator.BMICalculatorActivity
import com.example.tubes.ui.healtharticle.HealthArticleActivity
import com.example.tubes.ui.notessqlite.NoteActivity

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imgBmi.setOnClickListener {
                val intent = Intent(this@MainMenuActivity, BMICalculatorActivity::class.java)
                startActivity(intent)
            }
            imgHealthArticle.setOnClickListener {
                val intent = Intent(this@MainMenuActivity, HealthArticleActivity::class.java)
                startActivity(intent)
            }
            imgAskIca.setOnClickListener {
                val intent = Intent(this@MainMenuActivity, AskIcaActivity::class.java)
                startActivity(intent)
            }
            imgEmotionBook.setOnClickListener {
                val intent = Intent(this@MainMenuActivity, NoteActivity::class.java)
                startActivity(intent)
            }
        }
    }
}