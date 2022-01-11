package com.example.api.Response.Issue


import com.google.gson.annotations.SerializedName

data class IssueResponseItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: User
)