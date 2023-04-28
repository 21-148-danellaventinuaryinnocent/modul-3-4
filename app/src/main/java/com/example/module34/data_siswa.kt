package com.example.modul34

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modul34.data.mahasiswa
import com.example.modul34.room.mhsDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.module34.R

class data_siswa : AppCompatActivity() {

    val db by lazy { mhsDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener ()
    }

    fun setupListener() {
        btn_simpan.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.DAO().addMhs(
                    mahasiswa(0, id_nama.text.toString(),
                        id_prodi.text.toString(),
                        id_alamat.text.toString())
                )

                finish()

            }
        }

    }
}
