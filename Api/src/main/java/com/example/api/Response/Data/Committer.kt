package com.example.api.Response.Data


import com.google.gson.annotations.SerializedName

data class Committer(
    @SerializedName("date")
    val date: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String
)