package com.pkmobileapps.scalehunter.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBar() {
  TopAppBar(
    title = { Text("") },
    actions = {
      IconButton(onClick = {}) {
        Icon(
          imageVector = Icons.Default.Settings,
          contentDescription = "Settings"
        )
      }
    }
  )
}