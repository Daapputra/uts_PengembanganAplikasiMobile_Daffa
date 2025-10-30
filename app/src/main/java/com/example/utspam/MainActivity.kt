package com.example.utspam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memuat layout XML untuk Screen 1
        setContentView(R.layout.activity_screen1)

        // Mendapatkan referensi ke tombol "Mesen Makanan"
        val btnMesenMakanan = findViewById<Button>(R.id.btn_mesen_makanan)

        // Menambahkan aksi ketika tombol diklik (pindah ke SignUpActivity)
        btnMesenMakanan.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
