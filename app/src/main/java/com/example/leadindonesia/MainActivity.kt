package com.example.leadindonesia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeadRegistrationScreen(
                onNextClicked = { emailValid, fileValid ->
                    if (emailValid && fileValid) {
                        Toast.makeText(this, "Navigasi ke halaman berikutnya", Toast.LENGTH_SHORT).show()
                        // Tambahkan navigasi ke halaman berikutnya di sini
                    } else {
                        Toast.makeText(this, "Email atau ukuran file tidak valid", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}