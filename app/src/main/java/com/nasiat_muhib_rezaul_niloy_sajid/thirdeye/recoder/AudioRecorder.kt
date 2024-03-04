package com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.recoder

import java.io.File

interface AudioRecorder {

    fun startRecording(outputFile: File)

    fun stopRecording()
}