package com.example.myweatherapp.model

data class WeatherItem(
    val temperature: String,
    val description: String,
    val wind: String,
    val forecast: ArrayList<WeatherModel>,
)
