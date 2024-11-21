package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MainProgram(modifier: Modifier = Modifier){
    var nama by rememberSaveable { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var pilihjeniskelamin by remember { mutableStateOf("") }

    val jeniskelamin = listOf("Laki-laki", "Perempuan")

    var namaPengguna by rememberSaveable { mutableStateOf("") }
    var noHPPengguna by remember { mutableStateOf("") }
    var jeniskelaminPengguna by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue).padding(10.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Row(modifier = Modifier.padding(2.dp)) {
                Column(
                    Modifier.padding(top = 20.dp)
                ) {
                    Column (Modifier.padding(bottom = 10.dp)){
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "Menu",
                            Modifier.padding(end = 5.dp).size(25.dp),
                            tint = Color.White,
                        )
                    }

                    Column {
                        Text(
                            text = "Halo,",
                            fontSize = 25.sp,
                            color = Color.White,
                        )

                        Spacer(Modifier.padding(3.dp))

                        Text(
                            text = namaPengguna,
                            color = Color.White
                        )

                    }
                }

                Spacer(modifier = Modifier.padding(end = 180.dp))

                Box(contentAlignment = Alignment.BottomEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.naga),
                        contentDescription = "",
                        Modifier.size(100.dp).clip(shape = CircleShape)
                    )
                }
            }
        }
        
        Column(Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Yuk Lengkapi Data Diri!",
                fontWeight = FontWeight.Bold)

            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                placeholder = { Text("Masukkan nama anda") },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )

            OutlinedTextField(
                value = noHP,
                onValueChange = { noHP = it },
                placeholder = { Text("Masukkan no HP anda") },
                label = { Text("No Handphone") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(5.dp).padding(bottom = 10.dp)
            )

            Column {
                Row{
                    Text("Jenis Kelamin")
                }
                Row() {
                    jeniskelamin.forEach { item ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(selected = pilihjeniskelamin == item,
                                onClick = {
                                    pilihjeniskelamin = item
                                })
                            Text(item)
                        }
                    }
                }
            }


            Button(
                onClick = {
                    namaPengguna = nama
                    jeniskelaminPengguna = pilihjeniskelamin
                    noHPPengguna = noHP
                },
                Modifier.fillMaxWidth()
                
            ) {
                Text("Simpan")
            }

            Card(modifier.size(height = 80.dp, width = 340.dp).padding(top = 20.dp)) {
                CardSection(judulParam = "Nomor Handphone", isiParam = noHPPengguna)
                CardSection(judulParam = "Jenis Kelamin", isiParam = jeniskelaminPengguna)
            }
        }
    }
}

@Composable
fun CardSection (judulParam: String, isiParam: String) {
    Column (horizontalAlignment = Alignment.Start){

        Row (modifier = Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.Start)
        {
            Spacer(Modifier.padding(top = 30.dp))
            Text(text = judulParam, modifier = Modifier.weight(2f).padding(start = 10.dp))
            Text(text = ":", modifier = Modifier.weight(0.2f).padding(start = 10.dp))
            Text(text = "$isiParam", modifier = Modifier.weight(2f).padding(start = 10.dp))
        }
    }
}