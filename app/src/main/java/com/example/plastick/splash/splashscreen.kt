package com.example.plastick.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.plastick.MainActivity
import com.example.plastick.login.login_activity
import com.google.firebase.auth.FirebaseAuth


class splashscreen : AppCompatActivity() {

 //   var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val time : Long = 1500

        Handler().postDelayed(Runnable {

//            val user = mAuth!!.currentUser
//            if (user == null) {
//                startActivity(Intent(this@splashscreen, login_activity::class.java))
//            }
//
//            else
//            {
            val intent = Intent(splashscreen@ this, MainActivity::class.java)
            startActivity(intent)
            finish()

       // }
        }, time)



    }
}