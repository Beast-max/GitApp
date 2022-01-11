package com.example.githubapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.githubapp.fragment.BranchFragment
import com.example.githubapp.fragment.IssueFragment

class ViewpagerAdapter(fragmentAdapter:FragmentManager,lifecycle:Lifecycle,Sha:String,Username:String,Reponame:String):FragmentStateAdapter(fragmentAdapter,lifecycle){
    val sha = Sha
    val username = Username
    val reponame = Reponame
    override fun getItemCount(): Int {
        return 2
    }

   override fun createFragment(position: Int): Fragment {
   return  when(position){
           0-> BranchFragment.newInstance(sha,username,reponame)

            1-> IssueFragment.newInstance(username,reponame)
         else->{
             Fragment()
         }
        }
    }
}