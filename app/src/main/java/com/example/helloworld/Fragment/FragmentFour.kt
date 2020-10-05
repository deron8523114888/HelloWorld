package com.example.helloworld.Fragment

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.helloworld.R
import kotlinx.android.synthetic.main.fragment_four.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetAddress
import java.net.Socket

class FragmentFour : Fragment() {


    var msgString = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_four, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAsyncTask()

    }

    fun startAsyncTask() {


        /**
         *  AsyncTask 1
         */
        val asyncTask = MyAsyncTask(this)

        asyncTask.execute()


        /**
         *  AsyncTask 2
         */
        val asyncTask2 = object : AsyncTask<Unit, String, Unit>() {

            override fun doInBackground(vararg params: Unit?) {
                TODO("Not yet implemented")
            }

            override fun onProgressUpdate(vararg values: String?) {
                super.onProgressUpdate(*values)
            }
        }

        asyncTask2.execute()
    }

    private class MyAsyncTask(val fragment: FragmentFour) : AsyncTask<Unit, String, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            val serverIp = InetAddress.getByName("IP")
            val socket = Socket(serverIp, 12345)

            val brChat = BufferedReader(InputStreamReader(socket.getInputStream()))

            val msg = brChat.readLine()
            while (msg != null) {
                publishProgress(msg)
            }
        }

        override fun onProgressUpdate(vararg values: String?) {

            /**
             *  當次訊息
             */
            Log.v("get_message", values.toString())

            /**
             *  加入暫存
             */
            fragment.msgString += "$values\n\n"

            /**
             *  顯示
             */
            fragment.tv_chat_msg.text = fragment.msgString

            super.onProgressUpdate(*values)
        }


    }

}

