package com.example.githubapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.api.Response.Data.RepoResponse
import com.example.githubapp.AddRepo.RepoViewModel
import com.example.githubapp.ApiRepo.Calls
import com.example.githubapp.database.RepoData


class RepoDetailFragment() : Fragment() {


    private lateinit var model:RepoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_repo_detail, container, false)
        model = ViewModelProvider(requireActivity()).get(RepoViewModel::class.java)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username: TextView = view.findViewById(R.id.Enterusername)
        val reponame: TextView = view.findViewById(R.id.Enterreponame)
        view.findViewById<Button>(R.id.add_repo).setOnClickListener {
            if(username.text.isNotBlank() && reponame.text.isNotBlank()){
                Calls.fatchRepo(username.text.toString(),reponame.text.toString(),::OnSuccess,::OnError)
            }
        }

    }
    fun OnSuccess(data: RepoResponse){
        val reponame:String = data.name
        val discription:String? = data.description
        val url:String = data.htmlUrl
        val username:String = data.owner.login
        val repodetail = RepoData(null,username,reponame,discription,url)
        model.insert(repodetail)
        Toast.makeText(activity,"Data attached successfully", Toast.LENGTH_LONG).show()
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(MainActivity.PREFS_FILE_AUTH,
            Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("id",0)
        editor.apply()
        setfragment(RepoListFragment())
    }
    fun OnError(){
        Toast.makeText(activity,"Enter valid Username or Cheak Internet Connection", Toast.LENGTH_LONG).show()
    }
    private fun setfragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
    //    transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.enter_from_right)
        transaction.replace(R.id.fram,fragment)
        transaction.commit()
    }
}