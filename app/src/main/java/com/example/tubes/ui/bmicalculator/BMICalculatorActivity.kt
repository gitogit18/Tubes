package com.example.tubes.ui.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tubes.R
import com.example.tubes.databinding.ActivityBmicalculatorBinding

class BMICalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmicalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmicalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {

            var sts: String
            btnCalculate.setOnClickListener {
                val beratBadan = edtBeratBadan.text.toString().trim()
                val tinggiBadan = edtTinggiBadan.text.toString().trim()
                val tinggi = tinggiBadan.toDouble() / 100
                val calculate = beratBadan.toDouble() / (tinggi * tinggi)
                sts = if (calculate < 18.5) {
                    "Berat Badan Kurang (Underweight)"
                } else if (calculate < 22.9) {
                    "Berat Badan Normal"
                } else if (calculate < 24.9) {
                    "Berat Badan Berlebih (Overweight)"
                } else if (calculate < 29.9) {
                    "Obesitas I"
                } else {
                    "Obesitas II"
                }

                tvResult.text = "BMI $sts"

            }

        }
    }
}
