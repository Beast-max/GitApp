package com.example.githubapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.Response.Data.CommitResponse
import com.example.api.Response.Issue.IssueResponse
import com.example.api.Response.Issue.IssueResponseItem
import com.example.githubapp.Adapter.BranchAdapter
import com.example.githubapp.Adapter.IssueAdapter
import com.example.githubapp.ApiRepo.Calls
import com.example.githubapp.R
import kotlinx.android.synthetic.main.fragment_branch.*
import kotlinx.android.synthetic.main.fragment_issue.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class IssueFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        Calls.Issue(param1!!,param2!!,::OnSuccess)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_issue, container, false)
        view.findViewById<ProgressBar>(R.id.progressBar2).visibility = View.VISIBLE
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IssueFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun OnSuccess(list:ArrayList<IssueResponseItem>){
        progressBar2.visibility = View.GONE
        show(list)

    }
    fun show(list:ArrayList<IssueResponseItem>){
        issueRecyclerView.apply {
            issueRecyclerView.adapter = IssueAdapter(list)
            issueRecyclerView.layoutManager = LinearLayoutManager(activity)

        }
    }
}