package com.example.helloworld.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.RankAdapter
import kotlinx.android.synthetic.main.fragment_three.*

class FragmentThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_three, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        recyclerview?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RankAdapter(mutableListOf("fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake","fake"))
        }
        super.onViewCreated(view, savedInstanceState)
    }

}