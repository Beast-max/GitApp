package com.example.api.Response.Data


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("additions")
    val additions: Int,
    @SerializedName("deletions")
    val deletions: Int,
    @SerializedName("total")
    val total: Int
)