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

        val presenter = Presenter(this)

        btn_login.setOnClickListener {
            val account = et_account.text.toString()
            val password = et_password.text.toString()

            presenter.compare(account, password)

        }

        btn_reset.setOnClickListener {
            et_account.text.clear()
            et_password.text.clear()
        }

    }

    fun showSuccess() {
        Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show()
    }

    fun showFailure() {
        Toast.makeText(this, "登入失敗", Toast.LENGTH_SHORT).show()
    }

}