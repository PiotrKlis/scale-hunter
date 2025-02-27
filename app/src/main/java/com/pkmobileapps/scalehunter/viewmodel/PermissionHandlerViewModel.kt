package com.pkmobileapps.scalehunter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PermissionHandlerViewModel : ViewModel() {

  private val _permissionData = MutableLiveData<PermissionData>()
  val permissionData: LiveData<PermissionData> = _permissionData


  fun updateState(state: PermissionData) {
    _permissionData.value = state
  }
}

data class PermissionData(
  val isGranted: Boolean = false,
  val shouldShowRationaleDialog: Boolean = false,
  val shouldNavigateToSettings: Boolean = false,
  val shouldShowNavigateToSettingsDialog: Boolean = false,
)
