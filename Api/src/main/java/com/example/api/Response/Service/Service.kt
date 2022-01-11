package com.example.api.Response.Service

import com.example.api.Response.Data.BranchResponse
import com.example.api.Response.Data.CommitResponse
import com.example.api.Response.Data.RepoResponse
import com.example.api.Response.Issue.IssueResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("repos/{owner}/{repo}")
    fun getRepo(@Path("owner")owner:String,@Path("repo")reponame:String): Call<RepoResponse>
    @GET("repos/{owner}/{repo}/branches")
    fun getBranch(@Path("owner")owner:String,@Path("repo") reponame: String):Call<BranchResponse>
    @GET("repos/{owner}/{repo}/commits")
   fun getCommits(@Path("owner")owner:String,@Path("repo")reponame:String,@Query("Sha")Sha:String):Call<List<CommitResponse>>
    @GET("repos/{owner}/{repo}/issues")
    fun getIssue(@Path("owner")owner:String,@Path("repo")reponame:String,@Query("state")state:String):Call<IssueResponse>
}