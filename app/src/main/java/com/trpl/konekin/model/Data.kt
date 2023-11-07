package com.trpl.konekin.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nameApi: String,
    @SerializedName("status")
    val statusApi: String,
    @SerializedName("species")
    val speciesType: String,
    @SerializedName("gender")
    val speciesGender: String,
    @SerializedName("image")
    val speciesImage: String
)
