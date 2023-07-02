package com.example.plastick.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plastick.MainActivity
import com.example.plastick.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth


class signup_activity : AppCompatActivity() {

    var etRegEmail: TextInputEditText? = null
    var etRegPassword: TextInputEditText? = null
    var signup: Button? = null

    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup = findViewById(R.id.signup_button2);
        etRegEmail = findViewById(R.id.editTextTextEmailAddress2)
        etRegPassword = findViewById(R.id.editTextTextPassword2)

        mAuth = FirebaseAuth.getInstance();

        signup?.setOnClickListener {

            createUser();
//            val intent = Intent(signup_activity@this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
        }

    }

    private fun createUser() {
        val email = etRegEmail!!.text.toString()
        val password = etRegPassword!!.text.toString()
        if (TextUtils.isEmpty(email)) {
            etRegEmail!!.error = "Email cannot be empty"
            etRegEmail!!.requestFocus()
        } else if (TextUtils.isEmpty(password)) {
            etRegPassword!!.error = "Password cannot be empty"
            etRegPassword!!.requestFocus()
        } else {
            mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this@signup_activity,
                        "User registered successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@signup_activity, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        this@signup_activity,
                        "Registration Error please check your email/password: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}