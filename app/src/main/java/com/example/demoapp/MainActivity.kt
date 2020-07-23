package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoapp.ui.contact.ContactListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ContactListFragment.newInstance())
                    .commitNow()
        }
    }
}