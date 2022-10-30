package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val date:Int = 1999;
        var age:Int = 0 ;
        val cal:Calendar = Calendar.getInstance();
        age = cal.get(Calendar.YEAR)-date ;
        println("Votre age = $age");


        var clic = findViewById<Button>(R.id.b1)

        clic.setOnClickListener {
            clic.text = age.toString()
        }

    }
}
