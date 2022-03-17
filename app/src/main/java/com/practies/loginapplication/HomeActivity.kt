package com.practies.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val email_text=findViewById<TextView>(R.id.textView3)
          val sign_out=findViewById<Button>(R.id.sign_out)


        val      googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val    googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

                  supportActionBar?.hide()
      val email=  intent.getStringExtra("email")

        email_text.text=email


        sign_out.setOnClickListener{
            googleSignInClient.signOut()
                .addOnCompleteListener (this , OnCompleteListener { signOut() })
        }

    }

    private fun signOut() {
      Toast.makeText(this,"you are signOuted ",Toast.LENGTH_SHORT).show()
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}