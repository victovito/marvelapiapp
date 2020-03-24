package com.victorrosa.marvelapi

import com.victorrosa.marvelapi.adapters.Character
import retrofit2.Retrofit
import java.util.*

class MarvelAPI {
    companion object {

        var publicKey: String = "bf9751ccfd133fbc8aa1da88545c6115"
        var privateKey: String = "5d5d1d52ba663a4acd5643a286202ffb8d343964"

        fun getPathParameters() : Map<String, String> {

            val ts = Date().time.toString()
            val apikey = publicKey
            val hash = (ts + privateKey + publicKey).md5()

            return mapOf(
                "ts" to ts,
                "apikey" to apikey,
                "hash" to hash
            )

        }

    }
}