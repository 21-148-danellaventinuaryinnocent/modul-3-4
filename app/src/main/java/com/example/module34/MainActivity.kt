package com.example.modul34

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.modul34.room.mhsDB
import com.example.module34.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val db by lazy { mhsDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()

    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val siswa = db.DAO().getMhs()
            Log.d("MainActivity", "dbresponse: $siswa")
        }
    }

    fun setupListener() {
        btn_simpan.setOnClickListener {
            startActivity(Intent(this, data_siswa::class.java))
        }
    }
}


