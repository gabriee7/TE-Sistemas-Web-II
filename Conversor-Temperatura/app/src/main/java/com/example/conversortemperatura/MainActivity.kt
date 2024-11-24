package com.example.conversortemperatura

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnConverter.setOnClickListener{
            converter()
        }
    }


    fun converter(){
        val temperatura = binding.inputTemp.text.toString().toFloat()
        val optionCelsius = binding.rBtnCelsius.isChecked
        val optionFahrenheit = binding.rBtnFahrenheit.isChecked
        var result = 0.0

        if (optionCelsius){
            result = (temperatura - 32) / 1.8
        }else if (optionFahrenheit){
            result = (temperatura * 1.8) + 32
        }

        binding.textResult.text = "Resultado:  ${String.format("%.2f", result)}°"
    }
}