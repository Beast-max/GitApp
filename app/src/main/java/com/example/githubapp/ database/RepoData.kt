package com.example.githubapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RepoData_table")
data class RepoData(
    @PrimaryKey(autoGenerate = true)
    val repoid: Int?,

    @ColumnInfo(name= "Username")
    var Username:String="",

    @ColumnInfo(name = "Repo_name")
    var Reponame:String="",

    @ColumnInfo(name = "discription")
    var discription:String?="",

    @ColumnInfo(name = "Repo_Url")
    var repo_url:String,
)
