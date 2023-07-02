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


class login_activity : AppCompatActivity() {

//    private val RC_SIGN_IN = 89
//    private lateinit var googleSignInClient: GoogleSignInClient

    var etRegEmail: TextInputEditText? = null
    var etRegPassword: TextInputEditText? = null
    var signin: Button? = null

    var mAuth: FirebaseAuth? = null
    var signup: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signin = findViewById(R.id.signup_button);
        etRegEmail = findViewById(R.id.editTextTextEmailAddress)
        etRegPassword = findViewById(R.id.editTextTextPassword)

        mAuth = FirebaseAuth.getInstance();

        signup = findViewById(R.id.register);

        signup?.setOnClickListener {
            val intent = Intent(login_activity@ this, signup_activity::class.java)
            startActivity(intent)
            finish()
        }

        signin?.setOnClickListener {
            loginUser();
        }

    }

    private fun loginUser() {
        val email: String = etRegEmail!!.text.toString()
        val password: String = etRegPassword!!.text.toString()
        if (TextUtils.isEmpty(email)) {
            etRegEmail!!.error = "Email cannot be empty"
            etRegEmail!!.requestFocus()
        } else if (TextUtils.isEmpty(password)) {
            etRegPassword!!.error = "Password cannot be empty"
            etRegPassword!!.requestFocus()
        } else {
            mAuth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this@login_activity,
                        "User logged in successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@login_activity, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        this@login_activity,
                        "Log in Error: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}

//        // Configure Google Sign In
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//    }
//
//    fun signIn(view: android.view.View) {
//
//        val signInIntent = googleSignInClient.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                val account = task.getResult(ApiException::class.java)!!
//                firebaseAuthWithGoogle(account.idToken!!)
//            } catch (e: ApiException) {
//                Log.w("Fire89", "Google sign in failed", e)
//            }
//        }
//    }
//
//    private fun firebaseAuthWithGoogle(idToken: String) {
//
//        val auth = FirebaseAuth.getInstance()
//        val credential = GoogleAuthProvider.getCredential(idToken, null)
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    Log.d("Fire89", "signInWithCredential:success")
//
//                   // SharedPref.putBoolean(PrefConstants.IS_USER_LOGGED_IN, true)
//
//                    val user = auth.currentUser
//
//                    startActivity(Intent(this, MainActivity::class.java))
//
//                    Log.d("Fire89", "firebaseAuthWithGoogle: ${user?.displayName}")
//
//                } else {
//                    Log.w("Fire89", "signInWithCredential:failure", task.exception)
//                }
//            }

