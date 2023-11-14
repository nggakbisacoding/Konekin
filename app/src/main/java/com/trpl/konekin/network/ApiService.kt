package com.trpl.konekin.network

import com.trpl.konekin.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    fun getAllUsers(): Call<Users>
}