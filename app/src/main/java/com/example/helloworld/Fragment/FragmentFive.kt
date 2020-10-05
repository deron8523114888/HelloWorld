package com.example.helloworld.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.helloworld.R
import kotlinx.android.synthetic.main.fragment_five.*

class FragmentFive : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_five,container,false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->

            when(isChecked){
                true -> textView.text = "開啟"
                false -> textView.text = "關閉"
            }
        }

    }

}