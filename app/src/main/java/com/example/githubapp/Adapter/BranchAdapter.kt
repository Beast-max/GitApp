package com.example.githubapp.Adapter

import android.annotation.SuppressLint
import android.os.TestLooperManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.Response.Data.BranchResponse
import com.example.api.Response.Data.CommitResponse
import com.example.githubapp.Extensions.loadimage
import com.example.githubapp.R

class BranchAdapter(val Branchs:List<CommitResponse>):RecyclerView.Adapter<BranchAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.commitlayout,parent,false)
        return ViewHolder(view)
    }
   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val data: TextView = itemView.findViewById(R.id.textView6)
        val message:TextView = itemView.findViewById(R.id.commitermessage)
        val coname:TextView = itemView.findViewById(R.id.commiternaame)
        val image:ImageView = itemView.findViewById(R.id.commiterimage)
    }






    override fun getItemCount(): Int {
       return Branchs.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.message.text = Branchs[position].commit.message
        holder.image.loadimage(Branchs[position].author.avatarUrl)
        holder.coname.text = Branchs[position].commit.author.name
        holder.data.text = Branchs[position].commit.author.date


    }


}