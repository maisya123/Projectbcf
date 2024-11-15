package com.example.leadindonesia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.regex.Pattern
import androidx.compose.ui.tooling.preview.Preview
import com.example.leadindonesia.contest.ColorPalette
import com.example.leadindonesia.contest.StyledText


class ProfilLembaga : ComponentActivity() {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeadRegistrationScreen(onNextClicked: (Boolean, Boolean) -> Unit) {
    var NamaLembaga by remember { mutableStateOf("") }
    var emailLembaga by remember { mutableStateOf("") }
    var alamatLembaga by remember { mutableStateOf("") }
    var provinsi by remember { mutableStateOf("") }
    var kota by remember { mutableStateOf("") }
    var tanggalBerdiri by remember { mutableStateOf("") }
    var jenisLembaga by remember { mutableStateOf("") }
    var jenisCluster by remember { mutableStateOf("") }
    var fokusIsu by remember { mutableStateOf("") }
    var profilSingkat by remember { mutableStateOf("") }
    var alasanMengikuti by remember { mutableStateOf("") }
    var fileSize by remember { mutableStateOf(0L) } // Menyimpan ukuran file yang diunggah
    val emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$")

    // State untuk tahap registrasi
    val totalSteps = 5 // Asumsi jumlah total langkah registrasi
    val currentStep = 1 // 1 berarti langkah pertama yaitu "Profil Lembaga"

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.lead_indonesia_logo), // Logo aplikasi
                            contentDescription = "Logo Aplikasi",
                            modifier = Modifier.size(55.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle menu click */ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()), // Menambahkan scroll pada tampilan
                horizontalAlignment = Alignment.CenterHorizontally // Mengatur seluruh konten agar di tengah
            ) {
                // Teks "Pendaftaran LEAD Indonesia 2023" di tengah
                Text(
                    text = "Pendaftaran LEAD Indonesia 2023",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Profil Lembaga",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    style = StyledText.MobileLargeSemibold,
                    color = ColorPalette.PrimaryColor700
                )
                LinearProgressIndicator(
                    progress = currentStep / totalSteps.toFloat(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Form Fields
                OutlinedTextField(
                    value = NamaLembaga,
                    onValueChange = { NamaLembaga = it },
                    label = { Text("Nama lembaga") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = ColorPalette.Blue,
                        focusedBorderColor = ColorPalette.Danger500
                    ),
                    placeholder = {
                        Text("Masukan nama lembaga")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = emailLembaga,
                    onValueChange = { emailLembaga = it },
                    label = { Text("Email Format Lembaga") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }

                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = alamatLembaga,
                    onValueChange = { alamatLembaga = it },
                    label = { Text("Alamat Lengkap Lembaga") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }

                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = provinsi,
                    onValueChange = { provinsi = it },
                    label = { Text("Provinsi") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = kota,
                    onValueChange = { kota = it },
                    label = { Text("Kota/Kabupaten") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = tanggalBerdiri,
                    onValueChange = { tanggalBerdiri = it },
                    label = { Text("Tanggal Berdiri") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = jenisLembaga,
                    onValueChange = { jenisLembaga = it },
                    label = { Text("Jenis Lembaga Sosial") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = jenisCluster,
                    onValueChange = { jenisCluster = it },
                    label = { Text("Jenis Cluster Lembaga Sosial") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = fokusIsu,
                    onValueChange = { fokusIsu = it },
                    label = { Text("Fokus Isu") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("contoh@bcf.or.id")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = profilSingkat,
                    onValueChange = { profilSingkat = it },
                    label = { Text("Profil Singkat Lembaga") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("Berisi uraian penjelasan mengenai kritik dan saran dari peserta ")
                    }

                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = alasanMengikuti,
                    onValueChange = { alasanMengikuti = it },
                    label = { Text("Apa alasan Anda mengikuti LEAD Indonesia 2023?") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = RoundedCornerShape(24.dp),
                    placeholder = {
                        Text("Berisi uraian penjelasan mengenai kritik dan saran ...")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Unggah Dokumen Profil Perusahaan
                OutlinedButton(
                    onClick = {
                        // Simulasi file upload - ganti dengan fungsi yang sesuai untuk mendapatkan ukuran file
                        fileSize = 4 * 1024 * 1024 // 4 MB, sesuaikan sesuai fungsi upload Anda
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_upload_file_24), // Ganti dengan ikon unggahan yang tersedia
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Klik atau tarik file ke area ini untuk mengunggahnya\n" +
                                "Format file yang dapat diunggah hanya PDF, dengan ukuran maksimal 5 MB",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tombol Sebelumnya dan Berikutnya
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = {
                            // Validasi email dan ukuran file
                            val isEmailValid = emailPattern.matcher(emailLembaga).matches()
                            val isFileSizeValid = fileSize <= 5 * 1024 * 1024 // 5 MB
                            onNextClicked(isEmailValid, isFileSizeValid)
                        },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text("Berikutnya")
                    }
                }
            }
        }
    )
}


    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun LeadRegistrationScreenPreview() {
            LeadRegistrationScreen(onNextClicked = { _, _ -> /* Mock action for preview */ })
        }

