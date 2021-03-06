package com.example.helloworld

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity(), Contract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = Presenter(this)

        btn_login.setOnClickListener {
            val account = et_account.text.toString()
            val password = et_password.text.toString()

            presenter.compare(account, password)

        }

        btn_regist.setOnClickListener {
            et_account.text.clear()
            et_password.text.clear()
        }

    }

    override fun showSuccess() {
        Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show()
    }

    override fun showFailure() {
        Toast.makeText(this, "登入失敗", Toast.LENGTH_SHORT).show()
    }

    override fun goToMain2() {
        Handler().postDelayed({
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }


}