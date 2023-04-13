package com.example.cat.data

import com.example.cat.model.CatBreed
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatApi {
    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @GET("breeds")
    suspend fun getBreeds(): List<CatBreed>
}