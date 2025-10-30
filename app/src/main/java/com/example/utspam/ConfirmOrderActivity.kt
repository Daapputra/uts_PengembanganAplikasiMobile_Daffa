package com.example.utspam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)

        val selectedItems = intent.getSerializableExtra("selectedItems") as? ArrayList<MenuItem>
        val container = findViewById<LinearLayout>(R.id.container_selected_items)
        val btnNext = findViewById<Button>(R.id.btn_next)

        selectedItems?.forEach {
            val textView = TextView(this)
            textView.text = "${it.name} - Rp ${it.price}"
            textView.textSize = 16f
            textView.setPadding(8, 8, 8, 8)
            container.addView(textView)
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
    }
}
