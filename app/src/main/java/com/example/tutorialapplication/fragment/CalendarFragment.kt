package com.example.tutorialapplication.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorialapplication.R
import com.example.tutorialapplication.adaptor.DayGridAdaptor

class CalendarFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        val list: MutableList<String> = arrayListOf()
        for (i: Int in 1..30 ) {
            list.add("$i")
        }

        val adaptor = DayGridAdaptor(list)
        adaptor.diarySection = view.findViewById(R.id.diary_section)
        adaptor.diarySection.setOnClickListener {
            it.findNavController().navigate(R.id.action_calendarFragment_to_diaryFragment)
        }

        val recycleGrid = view.findViewById<RecyclerView>(R.id.date_grid)
        recycleGrid.adapter = adaptor

        return view
    }
}