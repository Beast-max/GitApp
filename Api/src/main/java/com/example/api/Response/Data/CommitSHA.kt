package com.example.api.Response.Data


import com.google.gson.annotations.SerializedName

data class CommitSHA(
    @SerializedName("sha")
    val sha: String,
    @SerializedName("url")
    val url: String
)