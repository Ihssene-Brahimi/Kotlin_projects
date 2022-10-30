package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate
import java.util.Calendar
import android.app.ActivityManager
import android.os.Environment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view)

        // Déclarer et initialiser l'ActivityManager

        val actManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        // Déclarer l'objet MemoryInfo

        val memInfo = ActivityManager.MemoryInfo()

        // Récupérer les données de l'ActivityManager

        actManager.getMemoryInfo(memInfo)

        // Récupérer la mémoire disponible et totale et la convertir en Giga Octets.

        val availMemory = memInfo.availMem.toDouble()/(1024*1024*1024)

        val totalMemory= memInfo.totalMem.toDouble()/(1024*1024*1024)

        val idd = Build.MODEL
        val ver = Build.VERSION.SDK_INT
        var bool:Boolean
        val isSDPresent:Boolean  = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)
        val isSDSpportedDevice:Boolean  = Environment.isExternalStorageRemovable()
        if(isSDSpportedDevice && isSDPresent)
        {
            bool = true
        }
        else
        {
            bool = false
        }

        // Affichage des informations dans le TextView

        mTextView.text = "Nom du périphérique: $idd\nVersion du système d’exploitation: $ver\nQuantité de RAM: $totalMemory\n" +
                "Stockage libre: $availMemory\nCarte mémoire disponible: $bool"

        // Affichage des informations sur la console
        println("Nom du périphérique: " + Build.MODEL);
        println("Version du système d’exploitation: " + Build.VERSION.SDK_INT);
        println("Quantité de RAM: " + totalMemory);
        println("Stockage libre: " + availMemory);
        println("Carte mémoire disponible: " + bool);

    }
}
