package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RankAdapter(var mutableList: MutableList<String> = fake()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        fun fake(): MutableList<String> {
            return ArrayList(10)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rank, null, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val num = position + 1
        holder.itemView.findViewById<TextView>(R.id.textview).setText("第" + num + "個")
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)