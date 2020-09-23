package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val myAdapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            // 這個方法需要返回一個你自訂的 Fragment
            override fun getItem(position: Int): Fragment {
                return PagerFragment(position)  // 這裡返回我自己訂的 Frament
            }

            // 這個方法需要返回 ViewPager 底下子畫面的數量
            override fun getCount(): Int {
                return 5  // 自己決定要幾個畫面
            }

        }

        viewpager.adapter = myAdapter // 設定 adapter 屬性

    }
}
