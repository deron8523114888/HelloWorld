package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            if (et_account.text.toString() == "1234" && et_password.text.toString() == "5678") {
                Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show()
                tv_error_msg.visibility = View.INVISIBLE
            }

            else {
                Toast.makeText(this, "登入失敗", Toast.LENGTH_SHORT).show()
                tv_error_msg.visibility = View.VISIBLE
            }
        }

        btn_reset.setOnClickListener {
            et_account.text.clear()
            et_password.text.clear()
            tv_error_msg.visibility = View.INVISIBLE
        }

    }
}
