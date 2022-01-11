package com.example.api.Response.Issue


import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("confused")
    val confused: Int,
    @SerializedName("eyes")
    val eyes: Int,
    @SerializedName("heart")
    val heart: Int,
    @SerializedName("hooray")
    val hooray: Int,
    @SerializedName("laugh")
    val laugh: Int,
    @SerializedName("rocket")
    val rocket: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("+1")
    val x: Int,
    @SerializedName("-1")
    val z: Int
)