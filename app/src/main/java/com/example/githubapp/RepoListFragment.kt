package com.example.githubapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.Response.Data.RepoResponse
import com.example.githubapp.Adapter.RepoAdapter
import com.example.githubapp.AddRepo.RepoViewModel
import com.example.githubapp.ApiRepo.Calls
import com.example.githubapp.database.RepoData
import kotlinx.android.synthetic.main.fragment_repo_list.*


class RepoListFragment : Fragment() {
private lateinit var model: RepoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_repo_list, container, false)
        model = ViewModelProvider(requireActivity())[RepoViewModel::class.java]

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reporecyclerview.apply {

            reporecyclerview.layoutManager = LinearLayoutManager(activity)
        }
model.getallrepo.observe(viewLifecycleOwner, Observer { RepoData->
  reporecyclerview.adapter  =RepoAdapter(RepoData,requireContext())
})

    }




    }
