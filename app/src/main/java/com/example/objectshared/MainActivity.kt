package com.example.objectshared

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.objectshared.model.Member
import com.example.sharedprfs.managers.PrefManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        var save = findViewById<Button>(R.id.save)
        var load = findViewById<Button>(R.id.load)
        var fullname = findViewById<EditText>(R.id.fullname)
        var age = findViewById<EditText>(R.id.age)
        var text = findViewById<TextView>(R.id.text)
        val manager = PrefManager(this)
        save.setOnClickListener {

            manager.getinstance(this)!!.saveObject(
                "Object",
                Member(fullname.text.toString().trim(), age.text.toString().trim())
            )

            Toast.makeText(this, "Save object", Toast.LENGTH_SHORT).show()
        }
        load.setOnClickListener {
            text.text=manager.getinstance(this)!!.fetchObject("Object",Member::class.java).toString()
            Toast.makeText(this, "Load object", Toast.LENGTH_SHORT).show()
        }

    }
}