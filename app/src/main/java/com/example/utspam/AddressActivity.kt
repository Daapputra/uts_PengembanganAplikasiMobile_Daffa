package com.example.utspam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        val etAddress = findViewById<EditText>(R.id.et_address)
        val btnConfirm = findViewById<Button>(R.id.btn_confirm)

        btnConfirm.setOnClickListener {
            val address = etAddress.text.toString()
            if (address.isEmpty()) {
                Toast.makeText(this, "Isi alamat terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pesanan dikirim ke: $address", Toast.LENGTH_LONG).show()

                val intent = Intent(this, OrderSuccessActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
