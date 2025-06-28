package com.example.fakeaccountdetector.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.fakeaccountdetector.data.model.Profile

@Composable
fun InputScreen(onCheckClick: (Profile) -> Unit) {
    val username = remember { mutableStateOf("") }
    val followers = remember { mutableStateOf("") }
    val following = remember { mutableStateOf("") }
    val accountAge = remember { mutableStateOf("") }
    val postsCount = remember { mutableStateOf("") }
    val hasProfilePic = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Fake Account Checker", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = followers.value,
            onValueChange = { followers.value = it },
            label = { Text("Followers") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = following.value,
            onValueChange = { following.value = it },
            label = { Text("Following") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = accountAge.value,
            onValueChange = { accountAge.value = it },
            label = { Text("Account Age (in months)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = postsCount.value,
            onValueChange = { postsCount.value = it },
            label = { Text("Posts Count") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = hasProfilePic.value,
                onCheckedChange = { hasProfilePic.value = it }
            )
            Text("Has Profile Picture")
        }

        Button(
            onClick = {
                val profile = Profile(
                    username = username.value,
                    followers = followers.value.toIntOrNull() ?: 0,
                    following = following.value.toIntOrNull() ?: 0,
                    accountAge = accountAge.value.toIntOrNull() ?: 0,
                    posts = postsCount.value.toIntOrNull() ?: 0,
                    hasProfilePic = hasProfilePic.value
                )
                onCheckClick(profile)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check Account")
        }
    }
}
