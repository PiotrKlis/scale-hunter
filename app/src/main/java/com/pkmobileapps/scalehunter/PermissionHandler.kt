package com.pkmobileapps.scalehunter

interface PermissionHandler {
  fun askForPermission(permission: String)
  fun shouldAskForPermission(permission: String)
}
