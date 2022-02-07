package com.example.myweatherapp.network

import com.example.myweatherapp.model.WeatherItem
import com.example.myweatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("weather/lagos")
    suspend fun getWeather(): Response<WeatherItem>

    @GET("weather/lagos/forecast")
    suspend fun getDailyWeather(): Response<WeatherModel>

}