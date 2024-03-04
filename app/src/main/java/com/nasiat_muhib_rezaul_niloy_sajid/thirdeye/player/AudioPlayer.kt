package com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.player

import java.io.File

interface AudioPlayer {
    fun playAudio(file: File)
    fun stopAudio()
}