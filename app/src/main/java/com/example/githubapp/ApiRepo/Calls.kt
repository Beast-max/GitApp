package com.example.githubapp.ApiRepo

import ApiClint
import androidx.core.view.OneShotPreDrawListener
import com.example.api.Response.Data.*
import com.example.api.Response.Issue.IssueResponse
import com.example.api.Response.Issue.IssueResponseItem
import com.example.api.Response.Issue.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object Calls {
    val api = ApiClint.api

    fun fatchRepo(
        Username: String,
        Reponame: String,
        OnSuccess: (repodata: RepoResponse) -> Unit,
        OnError: () -> Unit
    ) {
        api.getRepo(Username, Reponame).enqueue(object : Callback<RepoResponse> {
            override fun onResponse(call: Call<RepoResponse>, response: Response<RepoResponse>) {
                if (response.isSuccessful) {
                    OnSuccess.invoke(response.body()!!)
                }
            }

            override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                OnError.invoke()
            }

        })
    }

    fun fatchCommits(
        Username: String,
        Reponame: String,
        Sha: String,
        OnSuccess: (List<CommitResponse>) -> Unit
    ) {
        api.getCommits(Username, Reponame, Sha)
            .enqueue(object : Callback<List<CommitResponse>> {
                override fun onResponse(
                    call: Call<List<CommitResponse>>,
                    response: Response<List<CommitResponse>>
                ) {
                    if (response.isSuccessful) {
                        OnSuccess.invoke(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<CommitResponse>>, t: Throwable) {

                }

            })

    }

    fun fatchbranchs(
        Username: String,
        Reponame: String,
        OnSuccess: (Usermae: String, Reponame: String, Sha: String) -> Unit
    ) {
        api.getBranch(Username, Reponame).enqueue(object : Callback<BranchResponse> {
            override fun onResponse(
                call: Call<BranchResponse>,
                response: Response<BranchResponse>
            ) {
                if (response.isSuccessful) {
                    OnSuccess.invoke(Username, Reponame, response.body()?.get(0)?.commit!!.sha)
                }
            }

            override fun onFailure(call: Call<BranchResponse>, t: Throwable) {

            }

        })
    }

    fun Issue(Username: String, Reponame: String, OnSuccess: (ArrayList<IssueResponseItem>) -> Unit) {
        api.getIssue(Username, Reponame, "open").enqueue(object : Callback<IssueResponse> {
            override fun onResponse(call: Call<IssueResponse>, response: Response<IssueResponse>) {
                if (response.isSuccessful) {
                    OnSuccess.invoke(response.body()!!)
                }
            }

            override fun onFailure(call: Call<IssueResponse>, t: Throwable) {

            }

        })
    }
}