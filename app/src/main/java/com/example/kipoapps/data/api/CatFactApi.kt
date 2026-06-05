package com.example.kipoapps.data.api

import com.example.kipoapps.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApi {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}