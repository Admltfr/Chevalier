package com.example.firstapp.register_demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.components.CustomTextField
import com.example.firstapp.components.PassTextField

@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Register",
                fontSize = 24.sp
            )
            Text(
                text = "Daftar menggunakan username, email dan password anda.",
            )
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Username",
                hint = "Buat Username",
                value = username,
                onValueChange = { text ->
                    username = text
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username"
                    )
                }
            )
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Email",
                hint = "Masukkan Email",
                value = email,
                onValueChange = { text ->
                    email = text
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Password"
                    )
                }
            )
            PassTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Password",
                hint = "Buat Password",
                value = password,
                onValueChange = { text ->
                    password = text
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Username"
                    )
                }
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(),
                onClick = { }
            ) {
                Text(text = "Register")
            }
        }
    }
}