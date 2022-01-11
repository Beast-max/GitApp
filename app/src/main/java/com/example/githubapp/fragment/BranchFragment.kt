package com.example.githubapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.Response.Data.CommitResponse
import com.example.api.Response.Issue.User
import com.example.githubapp.Adapter.BranchAdapter
import com.example.githubapp.ApiRepo.Calls
import com.example.githubapp.R
import kotlinx.android.synthetic.main.fragment_branch.*


class BranchFragment : Fragment() {
    private var SHA_KEY: String? = null
    private var UserName:String?=null
    private var RepoName:String?=null
    companion object {
        private var SHA_KEY = "SHA"
       private var Username_Key = "Username"
        private var Reponame_Key = "Reponame"
        fun newInstance(SHA: String,Username_:String,Reponame_:String) =
            BranchFragment().apply {
                arguments = Bundle().apply {
                    putString(SHA_KEY, SHA)
                    putString(Username_Key,Username_)
                    putString(Reponame_Key,Reponame_)

                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_branch, container, false)
            view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            SHA_KEY = it.getString(SHA_KEY)
            UserName = it.getString(Username_Key)
            RepoName = it.getString(Reponame_Key)
        }
        Calls.fatchCommits(UserName!!,RepoName!!,SHA_KEY!!,::OnSuccess)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun OnSuccess(list:List<CommitResponse>){
        progressBar.visibility = View.GONE
        show(list)

    }
    fun show(list:List<CommitResponse>){
        branchRecyclerView.apply {
            branchRecyclerView.adapter = BranchAdapter(list)
            branchRecyclerView.layoutManager = LinearLayoutManager(activity)

        }
    }
}