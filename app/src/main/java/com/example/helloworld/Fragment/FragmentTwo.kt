package com.example.helloworld.Fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.helloworld.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_two.*

class FragmentTwo : Fragment() {

    val layoutList by lazy { listOf(chapter_one, chapter_two, chapter_three, chapter_four) }

    val state = arrayListOf(false, false, false, false)

    val btnList by lazy { listOf(btn_one, btn_two, btn_three, btn_four) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_two, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initEvent()

        super.onViewCreated(view, savedInstanceState)
    }


    fun initEvent() {
        btn_one.setOnClickListener(listener)
        btn_two.setOnClickListener(listener)
        btn_three.setOnClickListener(listener)
        btn_four.setOnClickListener(listener)
    }

    fun stateChange(position: Int) {

        if (state[position]) {
            layoutList[position].apply {
                closeAnimation()
                Handler().postDelayed({
                    visibility = View.GONE
                },500)
            }
            state[position] = false
        } else {
            layoutList[position].apply {
                visibility = View.VISIBLE
                openAnimation()
            }
            state[position] = true
        }
    }

    val listener = View.OnClickListener {
        when (it) {
            btn_one -> stateChange(0)
            btn_two -> stateChange(1)
            btn_three -> stateChange(2)
            btn_four -> stateChange(3)
        }
    }

    fun LinearLayout.openAnimation() {
        this.pivotY = 0f
        ObjectAnimator.ofFloat(this, "ScaleY", 0f, 1f).setDuration(500).start()
    }

    fun LinearLayout.closeAnimation() {
        ObjectAnimator.ofFloat(this, "ScaleY", 1f, 0f).setDuration(500).start()
    }

    fun canNotClick() {
        btnList.forEach {
            it.isClickable = false
        }
    }

    fun canClick() {
        btnList.forEach {
            it.isClickable = true
        }
    }

}