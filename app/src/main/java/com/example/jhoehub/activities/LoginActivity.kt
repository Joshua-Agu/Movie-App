package com.example.jhoehub.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jhoehub.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginPage: ConstraintLayout
    private lateinit var logLayout: LinearLayout
    private lateinit var loginPic: ImageView
    private lateinit var loginText: TextView
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var forgotPassword: TextView
    private lateinit var loginButton: Button
    private lateinit var registerNow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginpage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        loginPage = findViewById(R.id.loginpage)
        logLayout = findViewById(R.id.logLayout)
        loginPic = findViewById(R.id.login_pic)
        loginText = findViewById(R.id.login)
        forgotPassword = findViewById(R.id.forgotpassword)
        registerNow = findViewById(R.id.RegisterNow)

        initViiew()
        }

    private fun initViiew() {
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginbutton)

        loginButton.setOnClickListener {
            view ->
                if (username.text.toString().isEmpty() || password.text.toString().isEmpty()) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else if (username.text.toString() == "test" && password.text.toString() == "test") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)}
            }

        }
    }