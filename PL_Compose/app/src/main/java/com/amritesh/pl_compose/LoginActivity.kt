package com.amritesh.pl_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.focus.FocusRequester

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginPage() {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var passwordVisibility by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Email") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Mail, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            onImeActionPerformed = { action, _ ->
                if (action == ImeAction.Next) {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            }
        )

        var focusRequester by remember { mutableStateOf(FocusRequester()) }

        PasswordTextField(
            password = password,
            onValueChange = { password = it },
            onImeActionPerformed = {
                focusRequester.requestFocus()
            },
            passwordVisibility = passwordVisibility
        )

        Button(
            onClick = {
                // Handle login button click here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun PasswordTextField(
    password: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onImeActionPerformed: () -> Unit,
    passwordVisibility: Boolean
) {
    var isPasswordVisible by remember { mutableStateOf(passwordVisibility) }

    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .focusRequester(focusRequester),
        label = { Text(text = "Password") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    isPasswordVisible = !isPasswordVisible
                }
            ) {
                val icon = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                Icon(imageVector = icon, contentDescription = "Toggle Password Visibility")
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onImeActionPerformed = { action, _ ->
            if (action == ImeAction.Done) {
                onImeActionPerformed()
            }
        }
    )
}

@Composable
fun PasswordVisualTransformation(): VisualTransformation = VisualTransformation {
    // Replace each character with an asterisk
    buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            repeat(it.length) {
                append("•")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    FeatherAndroidTasksTheme {
        LoginPage()
    }
}
