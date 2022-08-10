package com.example.myandroidpractical27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class HomeActivity : AppCompatActivity() {
    val tvResult: TextView
        get() = findViewById(R.id.tv_reesult)

    lateinit var gso: GoogleSignInOptions
    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        var account = GoogleSignIn.getLastSignedInAccount(this)

        if(account!=null){
            tvResult.text = """
                personName = ${account.displayName}
                personGivenName  = ${account.givenName}
                personFamilyName  = ${account.familyName}
                personEmail  = ${account.email}
                personId = ${account.id}
                personPhoto  = ${account.photoUrl.toString()}
            """.trimIndent()

            Log.e("TAG", "onCreate: ${account.photoUrl.toString()}")
        }

        findViewById<Button>(R.id.btn_logout).setOnClickListener {

            mGoogleSignInClient.signOut().addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(applicationContext, "Logout successfully", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}