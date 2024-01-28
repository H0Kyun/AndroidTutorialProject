package com.example.tutorialapplication.chapter1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorialapplication.R
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme

class ComposeQuadrantActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialApplicationTheme {
                ComposeQuadrant()
            }
        }
    }
}
@Composable
fun ComposeQuadrant() {
    Column(modifier = Modifier.fillMaxSize()) {
        ComposeQuadrantRow(Modifier.weight(1.0F, true))
    }
}
@Composable
fun ComposeQuadrantRow(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        QuadrantInformation(
            Color(0xFFEADDFF),
            stringResource(R.string.second_quadrant_title),
            stringResource(R.string.second_quadrant_description),
            modifier
        )
        QuadrantInformation(
            Color(0xFFD0BCFF),
            stringResource(R.string.first_quadrant_title),
            stringResource(R.string.first_quadrant_description),
            modifier
        )
    }
    Row(modifier = modifier) {
        QuadrantInformation(
            Color(0xFFB69DF8),
            stringResource(R.string.third_quadrant_title),
            stringResource(R.string.third_quadrant_description),
            modifier
        )
        QuadrantInformation(
            Color(0xFFF6EDFF),
            stringResource(R.string.forth_quadrant_title),
            stringResource(R.string.forth_quadrant_description),
            modifier
        )
    }
}

@Composable
fun QuadrantInformation(
    backgroundColor: Color,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )

    }
}
@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    TutorialApplicationTheme {
        ComposeQuadrant()
    }
}