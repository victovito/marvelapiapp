package com.victorrosa.marvelapi

import com.victorrosa.marvelapi.services.CharacterService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient



class RetrofitInitializer {


//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://gateway.marvel.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    fun characterService() : CharacterService{
//        return retrofit.create(CharacterService::class.java)
//    }

    var API_BASE_URL = "https://gateway.marvel.com/"

    private var builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )

    var retrofit = builder
        .client(
            OkHttpClient.Builder().build()
        )
        .build()

    var client = retrofit.create<CharacterService>(CharacterService::class.java)

}