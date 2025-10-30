package com.example.utspam

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OrderSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_success)

        val btnDone = findViewById<Button>(R.id.btn_done)
        btnDone.setOnClickListener {
            finishAffinity() // Tutup semua activity, kembali ke home app
        }
    }
}
