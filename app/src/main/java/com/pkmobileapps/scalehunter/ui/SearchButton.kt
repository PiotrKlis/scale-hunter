package com.pkmobileapps.scalehunter.ui

import android.Manifest
import android.R.attr.scaleX
import android.R.attr.scaleY
import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pkmobileapps.scalehunter.AppSettingsHelper
import com.pkmobileapps.scalehunter.R
import com.pkmobileapps.scalehunter.viewmodel.PermissionData
import com.pkmobileapps.scalehunter.viewmodel.PermissionHandlerViewModel

@Preview
@Composable
fun SearchButton() {
  val viewModel = viewModel<PermissionHandlerViewModel>()
  val permissionData = viewModel.permissionData.observeAsState(PermissionData()).value
  val context = LocalActivity.current!!
  val animationScale = rememberInfiniteTransition(label = "")
    .animateFloat(2.0f, 3.0f, infiniteRepeatable(tween(1600), RepeatMode.Reverse), label = "")
    .value

  val permissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    when {
      isGranted -> viewModel.updateState(permissionData.copy(isGranted = true))

      shouldShowRequestPermissionRationale(context, Manifest.permission.RECORD_AUDIO) ->
        viewModel.updateState(PermissionData(shouldShowRationaleDialog = true))

      shouldShowRequestPermissionRationale(context, Manifest.permission.RECORD_AUDIO).not() ->
        viewModel.updateState(PermissionData(shouldNavigateToSettings = true, shouldShowNavigateToSettingsDialog = true))
    }
  }

  IconButton(
    onClick = {
      when {
        ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED -> {
          //start recording
        }

        permissionData.shouldNavigateToSettings == true -> viewModel.updateState(permissionData.copy(shouldShowNavigateToSettingsDialog = true))

        else -> permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
      }
    },
    modifier = Modifier
      .graphicsLayer {
        scaleX = animationScale
        scaleY = animationScale
      }
  ) {
    Box(
      modifier = Modifier
        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
        .padding(2.dp),
      contentAlignment = Alignment.Center
    ) {
      Image(
        painter = painterResource(id = R.drawable.baseline_music_note_48),
        contentDescription = "Note",
      )
    }
  }
  PermissionDialogs(viewModel, permissionData, permissionLauncher, context)
}

@Composable
private fun PermissionDialogs(
  viewModel: PermissionHandlerViewModel,
  permissionData: PermissionData,
  permissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
  context: Activity
) {
  when {
    permissionData.shouldShowRationaleDialog == true -> {
      AlertDialog(
        onDismissRequest = {
          viewModel.updateState(permissionData.copy(shouldShowRationaleDialog = false))
          permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        },
        title = { Text("Permission Required") },
        text = { Text("App needs permission to record audio") },
        confirmButton = {
          Button(onClick = {
            viewModel.updateState(permissionData.copy(shouldShowRationaleDialog = false))
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
          }) {
            Text("OK")
          }
        },
      )
    }

    permissionData.shouldShowNavigateToSettingsDialog == true -> {
      AlertDialog(
        onDismissRequest = {
          viewModel.updateState(permissionData.copy(shouldShowNavigateToSettingsDialog = false))
        },
        title = { Text("You have dismissed the permission dialog too many times") },
        text = { Text("You need to navigate to settings to enable permission") },
        confirmButton = {
          Button(onClick = {
            viewModel.updateState(permissionData.copy(shouldShowNavigateToSettingsDialog = false))
            AppSettingsHelper.openSettings(context)
          }) {
            Text("SETTINGS")
          }
        },
      )
    }
  }
}
