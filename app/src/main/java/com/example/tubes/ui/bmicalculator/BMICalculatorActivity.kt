package com.example.tubes.ui.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tubes.R

class BMICalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)
    }
    /*private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()

        if (weight != null && height != null){
            val bmi = weight/(height/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal weight"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }
            binding.resultText.text = "BMI: $bmiResult\nCategory: $bmiCategory"
        } else {
            binding.resultText.text = "Invalid Input"
        }
    }*/
}