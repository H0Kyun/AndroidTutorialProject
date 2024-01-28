package com.example.tutorialapplication.chapter1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorialapplication.R
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme

class BusinessCard: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardMainCompose()
        }
    }
}

@Composable
fun BusinessCardMainCompose() {
    val modifier = Modifier
    TutorialApplicationTheme {
        Surface(
            color = Color(0xFF3ddc84),
            modifier = modifier.fillMaxSize()
        ) {
            LogoAndName()
            PrivateInformation(modifier)
        }
    }
}

@Composable
fun LogoAndName() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "안드로이드 로고"
        )
        Text(
            text = "Hokyun",
            fontSize = 36.sp
        )
        Text(
            text = "Android",
            fontSize = 18.sp,
            color = Color(0xFF3d9762)
        )
    }
}

@Composable
fun PrivateInformation(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(bottom = 20.dp)
    ) {
        Column (horizontalAlignment = Alignment.Start){
            IconAndText(Icons.Filled.Call, stringResource(R.string.phone_number), modifier)
            IconAndText(Icons.Filled.Email, stringResource(R.string.email), modifier)
            IconAndText(Icons.Filled.Share, stringResource(R.string.share_text), modifier)
        }

    }
}

@Composable
fun IconAndText(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3d9762)
        )
        Spacer(modifier = modifier.width(30.dp))
        Text(
            text = text,
            fontSize = 13.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardMainCompose()

}