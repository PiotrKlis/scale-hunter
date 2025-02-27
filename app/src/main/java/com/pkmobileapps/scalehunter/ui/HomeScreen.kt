package com.pkmobileapps.scalehunter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeScreen() {
  Scaffold(
    topBar = { AppBar() }
  ) { innerPadding ->
    innerPadding.calculateTopPadding()
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      HeroTitle()
      SearchButton()
    }
  }
}


