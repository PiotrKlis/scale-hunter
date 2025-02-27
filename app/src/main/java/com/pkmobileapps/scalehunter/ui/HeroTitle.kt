package com.pkmobileapps.scalehunter.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HeroTitle() {
  Text(
    text = "Znajdź skalę",
    style = MaterialTheme.typography.displayLarge,
    modifier = Modifier
      .graphicsLayer {
        rotationX = 12f
      }
  )
}