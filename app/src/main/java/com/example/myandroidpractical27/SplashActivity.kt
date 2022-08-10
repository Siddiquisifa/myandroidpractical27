package com.example.myandroidpractical27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread(
            Runnable {
                Thread.sleep(3000)

                var account = GoogleSignIn.getLastSignedInAccount(this)

                if(account!=null)
                {
                    startActivity(Intent(applicationContext,HomeActivity::class.java ))
                }else{
                    startActivity(Intent(applicationContext,AuteticationActivity::class.java ))
                }


            }
        ).start()

    }
}