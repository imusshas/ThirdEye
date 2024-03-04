package com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.presentation


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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nasiat_muhib_rezaul_niloy_sajid.thirdeye.R

@Composable
fun AudioRecorderApp(
    onStartRecord: () -> Unit,
    onStopRecord: () -> Unit,
    onPlay: () -> Unit,
    onStop: () -> Unit,
) {
    var recordState by rememberSaveable { mutableStateOf(true) }
    var playStopState by rememberSaveable { mutableStateOf(true) }
    var buttonState by rememberSaveable { mutableStateOf(false) }
    val imageId = if (buttonState && playStopState) R.drawable.stop_button else R.drawable.play_button

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(350.dp)
                .width(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.red_background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mic),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        if (!buttonState) {
                            if (recordState) {
                                onStartRecord()
                                recordState = false
                            } else {
                                onStopRecord()
                                recordState = true
                                buttonState = true
                            }
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.4f))

        if (buttonState) {
            ElevatedButton(
                onClick = {
                    if (playStopState) {
                        onPlay()
                        playStopState = false
                    } else {
                        onStop()
                        playStopState = true
                        buttonState = false
                    }
                },
                shape = CircleShape,
                modifier = Modifier
                    .size(72.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp).align(Alignment.CenterVertically)
                )
            }
        } else {
            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AudioRecorderPreview() {
    AudioRecorderApp({},{},{},{})
}