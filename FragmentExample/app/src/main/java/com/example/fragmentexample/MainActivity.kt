package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       supportFragmentManager.beginTransaction()
           .add(R.id.fragment_container,FirstFragment())
           .commit()
       /* var manager=supportFragmentManager
        var transaction=manager.beginTransaction()
        transaction.add(R.id.fragment_container,FirstFragment())
        transaction.commit()*/
    }
}