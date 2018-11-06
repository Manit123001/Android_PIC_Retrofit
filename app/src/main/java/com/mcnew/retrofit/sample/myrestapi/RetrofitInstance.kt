package com.mcnew.retrofit.sample.myrestapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.myjson.com/"
    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        return retrofit
    }
}