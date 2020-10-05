package com.example.helloworld.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.helloworld.R
import com.example.helloworld.bean
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.core.FirestoreClient
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment(){


    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_one,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        readSingleData()
//        write()
    }



    private fun write(){
        val bean = bean("aa26645675","1234","Deron","建國中學",
            "ks557","甲級",8,33,13)


        db.collection("personalData").add(bean)
            .addOnCompleteListener {

                Toast.makeText(activity,"新增完成",Toast.LENGTH_SHORT).show()
            }

            .addOnSuccessListener {
                Toast.makeText(activity,"新增成功",Toast.LENGTH_SHORT).show()
            }

            .addOnFailureListener {
                Toast.makeText(activity,"新增失敗",Toast.LENGTH_SHORT).show()
            }

    }

    private fun readSingleData(){


        db.collection("personalData").document("45568zbjDzKX4SuZWrik").get()
            .addOnSuccessListener { result ->

                tv_name_right.text = result.data?.get("name").toString()
                tv_school_right.text = result.data?.get("school").toString()
                tv_email_right.text = result.data?.get("email").toString()
                Log.v("test__",result.id)
                Toast.makeText(activity, "讀取成功", Toast.LENGTH_SHORT).show()
            }

            .addOnFailureListener{
                Log.v("test__",it.toString())
                Toast.makeText(activity,"讀取失敗", Toast.LENGTH_SHORT).show()
            }
    }

}
