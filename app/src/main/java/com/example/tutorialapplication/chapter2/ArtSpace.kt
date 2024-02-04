package com.example.tutorialapplication.chapter2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorialapplication.R
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme

class ArtSpace : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var step by remember { mutableIntStateOf(1) }

    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val titleResource = "Lemon step$step"
    val descriptionResource = when (step) {
        1 -> R.string.lemon_first
        2 -> R.string.lemon_second
        3 -> R.string.lemon_third
        else -> R.string.lemon_forth
    }

    Column (
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(imageResource), contentDescription = "lemon")
        Spacer(modifier = Modifier.height(100.dp))
        ImageDescription(titleResource, descriptionResource)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(15.dp)
    ) {
        Button(
            onClick = { if (step == 1) step = 4 else --step }
        ) {
            Text(text = "previous")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = { if (step == 4) step = 1 else ++step }
        ) {
            Text(text = "next")
        }
    }
}

@Composable
fun ImageDescription(
    title: String,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title)
        Text(
            text = stringResource(description),
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun ArtSpacePreview() {
    TutorialApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ArtSpaceLayout()
        }
    }
}