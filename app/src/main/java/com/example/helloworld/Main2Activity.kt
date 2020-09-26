package com.example.helloworld

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.helloworld.Fragment.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val myAdapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            // 這個方法需要返回一個你自訂的 Fragment
            override fun getItem(position: Int): Fragment {

                when (position) {
                    0 -> return FragmentOne()
                    1 -> return FragmentTwo()
                    2 -> return FragmentThree()
                    3 -> return FragmentFour()
                    4 -> return FragmentFive()
                }



                return PagerFragment(position)  // 這裡返回我自己訂的 Frament
            }

            // 這個方法需要返回 ViewPager 底下子畫面的數量
            override fun getCount(): Int {
                return 5  // 自己決定要幾個畫面
            }

        }

        viewpager.adapter = myAdapter // 設定 adapter 屬性
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                bottomState(position)
            }
        })

    }


    fun bottomState(position: Int) {
        for (i in 0 until ll_bottom.childCount) {
            val textview = ll_bottom.getChildAt(i) as TextView

            if (i == position) {
                textview.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.orange))
                    compoundDrawables.forEach {
                        if (it != null) {
                            it.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, R.color.orange), PorterDuff.Mode.SRC_IN)
                        }
                    }
                }
            } else {
                textview.apply {
                    setTextColor(Color.GRAY)
                    compoundDrawables.forEach {
                        if (it != null) {
                            it.colorFilter = PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN)
                        }
                    }
                }
            }
        }
    }
}
