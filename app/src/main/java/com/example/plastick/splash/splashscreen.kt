package com.example.plastick.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.plastick.MainActivity

class splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val time : Long = 1500

        Handler().postDelayed(Runnable {

            val intent = Intent(splashscreen@this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, time)



    }
}