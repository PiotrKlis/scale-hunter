package com.pkmobileapps.scalehunter

class MusicRecorder : Recorder {
  override fun start() {
    TODO("Not yet implemented")
  }

  override fun stop() {
    TODO("Not yet implemented")
  }
}

/*
  private val requestPermissionLauncher x=
    registerForActivityResult(
      ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
      if (isGranted) {
        // Permission is granted. Start recording
      } else {
        // Explain to the user that the feature is unavailable.
        // Handle case of no permission to record.
      }
    }

  private var mediaRecorder: MediaRecorder? = null
  private var audioFilePath: String? = null
  private var isRecording = false

  private fun startRecording() {
    if (!isRecording) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        mediaRecorder = MediaRecorder(this).apply {
          setAudioSource(MediaRecorder.AudioSource.MIC)
          setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
          audioFilePath = getOutputFilePath()
          setOutputFile(audioFilePath)
          setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

          try {
            prepare()
            start()
            isRecording = true
            // Inform the user recording has started.
          } catch (e: IOException) {
            // Handle error.
            e.printStackTrace()
          }
        }
      } else {
        mediaRecorder = MediaRecorder().apply {
          setAudioSource(MediaRecorder.AudioSource.MIC)
          setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
          audioFilePath = getOutputFilePath()
          setOutputFile(audioFilePath)
          setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

          try {
            prepare()
            start()
            isRecording = true
            // Inform the user recording has started.
          } catch (e: IOException) {
            // Handle error.
            e.printStackTrace()
          }
        }
      }
    } else {
      stopRecording()
    }
  }

  private fun getOutputFilePath(): String {
    val directory = getExternalFilesDir(Environment.DIRECTORY_MUSIC)
    if (!directory?.exists()!!) {
      directory.mkdirs()
    }
    return directory.absolutePath + File.separator + "recording_${System.currentTimeMillis()}.3gp"
  }

  private fun stopRecording() {
    mediaRecorder?.apply {
      stop()
      release()
      isRecording = false
      // Inform the user recording has stopped.
      // Handle recorded file (save, upload, etc)
    }
    mediaRecorder = null
  }

  override fun onDestroy() {
    super.onDestroy()
    mediaRecorder?.release()
    mediaRecorder = null
  }*/