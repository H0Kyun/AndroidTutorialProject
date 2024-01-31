package com.example.tutorialapplication.chapter2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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

class LemonAde : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialApplicationTheme {
                LemonAdeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonAdeApp() {
    LemonAdeRecipe(
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonAdeRecipe(modifier: Modifier = Modifier) {
    var step by remember { mutableIntStateOf(1) }
    var squeezeTime by remember { mutableIntStateOf(0) }
    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when (step) {
        1 -> R.string.lemon_first
        2 -> R.string.lemon_second
        3 -> R.string.lemon_third
        else -> R.string.lemon_forth
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (step == 2 && squeezeTime > 0) {
                    --squeezeTime
                } else {
                    if(step == 1) {
                        squeezeTime = (2..4).random()
                    }
                    if (step > 3) step = 1 else ++step
                }
            },
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = step.toString()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResource),
            fontSize = 18.sp
        )
    }
}