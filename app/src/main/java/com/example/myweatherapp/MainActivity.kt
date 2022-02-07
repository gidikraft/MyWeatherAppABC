package com.example.myweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.network.Retrofit
import com.example.myweatherapp.ui.WeatherForecastActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weatherButton.setOnClickListener {
            launch(Dispatchers.IO){
                try {
                    val response = retrofit.apiClient.getWeather()

                    if (response.isSuccessful){
                        val data = response.body()

                        binding.description.text = data?.description
                        binding.temperature.text = data?.temperature
                        binding.windSpeed.text = data?.temperature
                    } else{
                        Toast.makeText(this@MainActivity, "Error due to: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception){
                    Toast.makeText(this@MainActivity, "${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.weatherForecastButton.setOnClickListener {
            val intent = Intent(this, WeatherForecastActivity::class.java)
            startActivity(intent)
        }
    }

}