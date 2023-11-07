package com.trpl.konekin.network

import com.trpl.konekin.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getAllUsers(): Call<Users>
}