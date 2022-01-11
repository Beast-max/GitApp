package com.example.api.Response.Data


import com.google.gson.annotations.SerializedName

data class File(
    @SerializedName("additions")
    val additions: Int,
    @SerializedName("blob_url")
    val blobUrl: String,
    @SerializedName("changes")
    val changes: Int,
    @SerializedName("contents_url")
    val contentsUrl: String,
    @SerializedName("deletions")
    val deletions: Int,
    @SerializedName("filename")
    val filename: String,
    @SerializedName("patch")
    val patch: String,
    @SerializedName("raw_url")
    val rawUrl: String,
    @SerializedName("sha")
    val sha: String,
    @SerializedName("status")
    val status: String
)