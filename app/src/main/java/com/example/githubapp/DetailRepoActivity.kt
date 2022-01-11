package com.example.githubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.api.Response.Data.CommitResponse
import com.example.githubapp.Adapter.BranchAdapter
import com.example.githubapp.Adapter.ViewpagerAdapter
import com.example.githubapp.ApiRepo.Calls
import com.example.githubapp.fragment.BranchFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_detail_repo.*

class DetailRepoActivity : AppCompatActivity() {
    val branchAdapter = BranchAdapter(mutableListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_repo)

        val reponame:TextView = findViewById(R.id.textView4)
        val Disription:TextView = findViewById(R.id.textView5)

      val repo:String  = intent.getStringExtra("RepoName").toString()
        val discription:String = intent.getStringExtra("Disription").toString()
        val username:String = intent.getStringExtra("Username").toString()
        reponame.text = repo
        Disription.text = discription
        Calls.fatchbranchs(username,repo,::OnSuccess)




    }
    fun OnSuccess(UserName:String,RepoName:String,Sha:String){
        val tablayout=   findViewById<TabLayout>(R.id.tab_layout)
        val viewpage = findViewById<ViewPager2>(R.id.view_pager_2)
        val adapter =ViewpagerAdapter(supportFragmentManager,lifecycle,Sha,UserName,RepoName)
        viewpage.adapter  =adapter
        TabLayoutMediator(tablayout,viewpage)
        {
                tab,position->
            when(position){
                0->{tab.text = "Commits"}

                1->{tab.text = "Issues"}

            }
        }.attach()



    }

}