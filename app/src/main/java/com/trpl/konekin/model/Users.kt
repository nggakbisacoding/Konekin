package com.trpl.konekin.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("results")
    val data: List<Data>
)
