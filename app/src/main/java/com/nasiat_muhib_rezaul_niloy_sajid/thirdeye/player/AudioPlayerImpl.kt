package com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.player

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import java.io.File

class AudioPlayerImpl(private val context: Context) : AudioPlayer {
    private var player: MediaPlayer? = null

    override fun playAudio(file: File) {
        MediaPlayer.create(context, file.toUri()).apply {
            player = this
            start()
        }
    }

    override fun stopAudio() {
        player?.stop()
        player?.release()
        player = null
    }
}