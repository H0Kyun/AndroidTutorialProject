package com.example.tutorialapplication.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapplication.R

class DayGridAdaptor (private val dataSet: MutableList<String>): RecyclerView.Adapter<DayGridAdaptor.ViewHolder>() {
    class ViewHolder(view: View, parentWidth: Int): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.date_item)

        init {
            textView.width = parentWidth / 7
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.date_item, parent, false)

        return ViewHolder(view, parent.width)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val index = position + 1

        holder.textView.text = "$index"
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}