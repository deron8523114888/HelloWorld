package com.example.helloworld

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment.*

class PagerFragment(val position: Int) : Fragment() {

    val colors = listOf(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.GRAY)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment, container,false)

        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val num = position + 1

        view.findViewById<TextView>(R.id.tv_number).apply {
            text = "這是 Fragment " + num
            setBackgroundColor(colors[position])
        }
        super.onViewCreated(view, savedInstanceState)
    }

}