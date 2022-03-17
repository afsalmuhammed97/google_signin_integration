package com.practies.loginapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


const val  RC_SIGN_IN=123
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val login_WithGoogle_bt= findViewById<Button>(R.id.logInB3)
        val signUp_button=findViewById<Button>(R.id.sign_up)
    val      googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

    val    googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        login_WithGoogle_bt.setOnClickListener{

            val signInIntent: Intent = googleSignInClient.getSignInIntent()
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        signUp_button.setOnClickListener{
            val intent=Intent(this,SignUpActivitiy::class.java)
            startActivity(intent)
            this.finish()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == RC_SIGN_IN) {
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            val acct = GoogleSignIn.getLastSignedInAccount(this)


            if (acct != null) {
                val personEmail = acct.email
                    val intent=Intent(this,HomeActivity::class.java).apply {
                                       putExtra("email",personEmail)
                    }
                    startActivity(intent)
                        this.finish()
                val personName = acct.displayName
                val personGivenName = acct.givenName
                val personFamilyName = acct.familyName


            }
        } catch (e: ApiException) {

           // Log.w(TAG, "signInResult:failed code=" + e.statusCode)

            Toast.makeText(this,"Login failed",Toast.LENGTH_SHORT).show()
        }
    }






    }

