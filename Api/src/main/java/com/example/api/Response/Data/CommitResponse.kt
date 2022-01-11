package com.example.api.Response.Data


import com.google.gson.annotations.SerializedName

data class CommitResponse(
    @SerializedName("author")
    val author: Author,

    @SerializedName("commit")
    val commit: Commit,


)