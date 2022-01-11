package com.example.api.Response.Data


import com.google.gson.annotations.SerializedName

data class BranchResponseItem(
    @SerializedName("commit")
    val commit: CommitSHA,
    @SerializedName("name")
    val name: String,
    @SerializedName("protected")
    val `protected`: Boolean
)