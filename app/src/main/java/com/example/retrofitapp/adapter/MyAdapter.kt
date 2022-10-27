package com.example.retrofitapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.model.Post

class MyAdapter:RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    private var myList= emptyList<Post>()
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.itemView.findViewById<TextView>(R.id.tvUserId).text=myList[position].userId.toString()
        holder.itemView.findViewById<TextView>(R.id.tvId).text=myList[position].id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvTitle).text=myList[position].title
        holder.itemView.findViewById<TextView>(R.id.tvBody).text=myList[position].body
    }
    override fun getItemCount(): Int
    {
        return myList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Post>)
    {
        myList=newList
        notifyDataSetChanged()
    }
}