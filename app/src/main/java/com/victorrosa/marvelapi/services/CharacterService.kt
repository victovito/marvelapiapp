package com.victorrosa.marvelapi.services

import com.victorrosa.marvelapi.adapters.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("v1/public/characters")
    fun list(
        @Query("hash") hash: String,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String
    ) : Call<List<Character>>

}