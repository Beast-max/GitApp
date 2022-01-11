package com.example.githubapp.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapp.DetailRepoActivity
import com.example.githubapp.R
import com.example.githubapp.database.RepoData

class RepoAdapter(val repos:List<RepoData>,val context: Context):RecyclerView.Adapter<RepoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.repolayout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.reponame.text = repos[position].Reponame
        holder.disription.text = repos[position].discription
        val url:String = repos[position].repo_url
        holder.share.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,"Hey here checkout my github repository $url")
                context.startActivity(Intent.createChooser(intent,"Sand to"))
        }
        holder.card.setOnClickListener {
            val intent = Intent(context,DetailRepoActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Username",repos[position].Username)
            bundle.putString("RepoName",repos[position].Reponame)
            bundle.putString("Disription",repos[position].discription)
            intent.putExtras(bundle)
            startActivity(context,intent,bundle)
        }
    }

    override fun getItemCount(): Int {
       return repos.size
    }
   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
       val reponame:TextView = itemView.findViewById(R.id.commiternaame)
       val disription:TextView = itemView.findViewById(R.id.ticket)
       val share:ImageView = itemView.findViewById(R.id.commiterimage)
       val card:CardView = itemView.findViewById(R.id.card)

    }
}