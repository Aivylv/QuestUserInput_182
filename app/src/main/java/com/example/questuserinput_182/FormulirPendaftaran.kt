package com.example.questuserinput_182

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Formulir(modifier: Modifier
){
    //variabel - variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textSP by remember { mutableStateOf("")}
    //variabel - variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}
    var status by remember {mutableStateOf("")}

    val gender:List<String> = listOf("Laki-laki", "Perempuan")
    val perkawinan:List<String> = listOf("Janda", "Lajang", "Duda")

    //COLUMN UTAMA (BACKGROUND)
    Column(modifier = Modifier.padding(top = 0.dp).background(color = Color(0xFFa9a4de)).fillMaxSize(),
    ){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF9e6bd5)),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = stringResource(R.string.form_name),
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }
        }

        //CARD FORMULIR
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 60.dp),
            shape = RoundedCornerShape(20.dp)
        ){
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
            {
                Text("NAMA LENGKAP",
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp))
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.small,
                    label = {Text("Isian Nama Lengkap")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onValueChange = {
                        textNama = it
                    }
                )
                Text("JENIS KELAMIN",
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp))
                Column {
                    gender.forEach { item ->
                        Row(modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            }
                        ), verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = {
                                    textJK = item
                                })
                            Text(item)
                        }
                    }
                }
                Text("STATUS PERKAWINAN",
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp))
                Column{
                    perkawinan.forEach { item ->
                        Row(modifier = Modifier.selectable(
                            selected = textSP == item,
                            onClick = {
                                textSP = item
                            }
                        ), verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = textSP == item,
                                onClick = {
                                    textSP = item
                                })
                            Text(item)
                        }
                    }
                }
                Text("ALAMAT",
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp))
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    label = { Text(text = "Alamat") },
                    onValueChange = {
                        textAlamat = it
                    }
                )

                // --- TOMBOL SUBMIT (DI DALAM KARTU) ---
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7251d2),
                        contentColor = Color.White
                    ),
                    onClick = {
                        nama = textNama
                        jenis = textJK
                        status = textSP
                        alamat = textAlamat
                    })
                {
                    Text(stringResource(R.string.submit))
                }
            }
        }


        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ){
            Column (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp))
            {
                Text(text = "Nama   : "+nama, color = Color.White )
                Text(text = "Gender : "+jenis, color = Color.White)
                Text(text = "Status : "+status, color = Color.White)
                Text(text = "Alamat : "+alamat, color = Color.White)
            }
        }
    }
}