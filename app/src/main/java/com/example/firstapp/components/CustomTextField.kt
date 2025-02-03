package com.example.firstapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon:  @Composable (() -> Unit)
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            leadingIcon = leadingIcon,
            placeholder = {
                Text(text = hint)
            }
        )
    }
}


@Composable
fun PassTextField(

    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon:  @Composable (() -> Unit)
) {

    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )

        var showPassword by remember { mutableStateOf(false) }

        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            leadingIcon = leadingIcon,
            placeholder = {
                Text(text = hint)
            },
            visualTransformation = if (showPassword) {

                VisualTransformation.None

            } else {

                PasswordVisualTransformation()

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
        )
    }
}

//fun CustomTextField(
//    modifier: Modifier = Modifier,
//    label: String,
//    hint: String,
//    value: String,
//    onValueChange: (String) -> Unit,
//    leadingIcon: @Composable (() -> Unit)? = null,
//    isPassword: Boolean = false // Tambahkan parameter password
//) {
//    var obscureText by remember { mutableStateOf(isPassword) }
//
//    Column(modifier = modifier) {
//        Text(
//            text = label,
//            style = MaterialTheme.typography.labelLarge
//        )
//        OutlinedTextField(
//            modifier = modifier,
//            value = value,
//            onValueChange = onValueChange,
//            leadingIcon = leadingIcon,
//            placeholder = { Text(text = hint) },
//            visualTransformation = if (obscureText) PasswordVisualTransformation() else VisualTransformation.None,
//            trailingIcon = {
//                if (isPassword) {
//                    IconButton(onClick = { obscureText = !obscureText }) {
//                        Icon(
//                            imageVector = if (obscureText) Icons.Filled.V else Icons.Filled.Visibility,
//                            contentDescription = if (obscureText) "Show password" else "Hide password"
//                        )
//                    }
//                }
//            }
//        )
//    }
//}