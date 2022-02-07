package com.example.myweatherapp.network

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

const val BASE_URL = "https://goweather.herokuapp.com/"

class Retrofit {

    val apiClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(API::class.java)



//    companion object{
//        val retrofitService : API by lazy {
//            apiClient.create(API::class.java)
//        }
//    }
}

