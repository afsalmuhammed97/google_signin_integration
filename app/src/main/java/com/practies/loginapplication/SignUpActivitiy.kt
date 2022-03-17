package com.practies.loginapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignUpActivitiy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_activitiy)
        supportActionBar?.hide()
    }
}