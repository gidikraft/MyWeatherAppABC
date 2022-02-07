package com.example.myweatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myweatherapp.R
import com.example.myweatherapp.network.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class WeatherForecastActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var retrofit: Retrofit
    private lateinit var day1: TextView
    private lateinit var windSpeed: TextView
    private lateinit var temperature: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)

        day1 = findViewById(R.id.day_1)
        windSpeed = findViewById(R.id.daily_wind_speed)
        temperature = findViewById(R.id.daily_temperature)
        description = findViewById(R.id.daily_description)

    }

    private fun loadWeather(){
        launch(Dispatchers.IO) {
            try {
                val response = retrofit.apiClient.getDailyWeather()

                if (response.isSuccessful){
                    val data = response.body()
                    if (data?.day == "1"){
                        temperature.text = data.temperature
                        windSpeed.text = data.wind
                    }

                } else{
                    Toast.makeText(this@WeatherForecastActivity, "Error due to: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception){
                Toast.makeText(this@WeatherForecastActivity, "${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}