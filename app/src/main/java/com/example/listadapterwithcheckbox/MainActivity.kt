package com.example.listadapterwithcheckbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.listadapterwithcheckbox.view.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.content_view, MainFragment())
            transaction.commit()
        }
    }
}