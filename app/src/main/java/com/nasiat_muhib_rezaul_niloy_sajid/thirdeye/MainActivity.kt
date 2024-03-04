package com.nasiat_muhib_rezaul_niloy_sajid.thirdeye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.player.AudioPlayerImpl
import com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.presentation.AudioRecorderApp
import com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.recoder.AudioRecorderImpl
import com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.ui.theme.ThirdEyeTheme
import java.io.File

class MainActivity : ComponentActivity() {

    private val recorder by lazy { AudioRecorderImpl(applicationContext) }
    private val player by lazy { AudioPlayerImpl(applicationContext) }
    private var audioFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirdEyeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    AudioRecorderApp(
                        onStartRecord = {
                            File(cacheDir, "audio.mp3").also {
                                recorder.startRecording(it)
                                audioFile = it
                            }
                        },

                        onStopRecord = {
                            recorder.stopRecording()
                        },
                        onPlay = {
                            player.playAudio(audioFile ?: return@AudioRecorderApp)
                        },
                        onStop = {
                            player.stopAudio()
                        }
                    )
                }
            }
        }
    }
}