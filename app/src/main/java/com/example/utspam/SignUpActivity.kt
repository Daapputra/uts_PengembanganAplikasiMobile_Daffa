package com.example.utspam

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val etName = findViewById<EditText>(R.id.et_name)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val etConfirm = findViewById<EditText>(R.id.et_confirm_password)
        val btnSignup = findViewById<Button>(R.id.btn_register)

        btnSignup.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val pass = etPassword.text.toString()
            val confirm = etConfirm.text.toString()

            // Validasi sederhana
            if (name.isEmpty()) {
                etName.error = "Nama harus diisi"
                etName.requestFocus()
                return@setOnClickListener
            }
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Email tidak valid"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (pass.length < 6) {
                etPassword.error = "Password minimal 6 karakter"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            if (pass != confirm) {
                etConfirm.error = "Password tidak sama"
                etConfirm.requestFocus()
                return@setOnClickListener
            }

            // Kalau valid -> pindah ke MenuActivity
            Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MenuActivity::class.java)
            // optional: kirim nama user
            intent.putExtra("user_name", name)
            startActivity(intent)
            finish()
        }
    }
}
