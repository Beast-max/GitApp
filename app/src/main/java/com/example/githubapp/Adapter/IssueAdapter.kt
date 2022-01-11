package com.example.githubapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.Response.Data.CommitResponse
import com.example.api.Response.Issue.IssueResponse
import com.example.api.Response.Issue.IssueResponseItem
import com.example.githubapp.Extensions.loadimage
import com.example.githubapp.R

class IssueAdapter(val Issue:ArrayList<IssueResponseItem>): RecyclerView.Adapter<IssueAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.issuelayout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.issmessage.text  = Issue[position].title
        holder.issuename.text = Issue[position].user.login
        holder.issueimage.loadimage(Issue[position].user.avatarUrl)
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val issuename:TextView = itemView.findViewById(R.id.issuenaame)
        val issmessage:TextView = itemView.findViewById(R.id.issuemessage)
        val issueimage:ImageView = itemView.findViewById(R.id.issueimage)
    }

    override fun getItemCount(): Int {
       return Issue.size
    }
}