package com.example.utspam

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    private lateinit var rvMenu: RecyclerView
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        rvMenu = findViewById(R.id.rv_menu)
        rvMenu.layoutManager = LinearLayoutManager(this)

        val menus = arrayListOf(
            MenuItem("Nasi Goreng Spesial", "Nasi goreng dengan telur dan ayam", 18000),
            MenuItem("Mie Goreng", "Mie goreng dengan potongan ayam", 15000),
            MenuItem("Ayam Geprek", "Ayam geprek pedas", 20000),
            MenuItem("Sate Ayam", "Sate ayam dengan sambal kacang", 22000),
            MenuItem("Bakso Kuah", "Bakso sapi lengkap", 17000),
            MenuItem("Nasi Uduk", "Nasi uduk + tahu + tempe", 14000),
            MenuItem("Pecel Lele", "Lele goreng + sambal", 19000),
            MenuItem("Mie Goreng", "Burger daging + kentang", 25000),
            MenuItem("Mie Kuah", "Nasi + sayur + ayam", 21000),
            MenuItem("Rendang Mini", "Rendang daging porsi kecil", 28000)
        )

        adapter = MenuAdapter(menus)
        rvMenu.adapter = adapter

        findViewById<android.view.View>(R.id.btn_proceed).setOnClickListener {
            val selected = adapter.getSelectedItems()
            if (selected.isEmpty()) {
                Toast.makeText(this, "Pilih minimal 1 menu terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // pindah ke halaman konfirmasi pesanan
            val intent = Intent(this, ConfirmOrderActivity::class.java)
            intent.putExtra("selectedItems", ArrayList(selected))
            startActivity(intent)
        }
    }
}
