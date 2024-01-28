package com.example.tutorialapplication.chapter1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorialapplication.R
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme

class LearnTogetherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialApplicationTheme {
                LearnTogetherColumn(
                    stringResource(R.string.learn_together_title),
                    stringResource(R.string.learn_together_first_content),
                    stringResource(R.string.learn_together_second_content)
                )
            }
        }
    }
}

@Composable
fun LearnTogetherColumn(title: String, firstContent: String, secondContent: String) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImage()
        LearnTogetherTitle(title)
        LearnTogetherContent(firstContent, secondContent)
    }
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(R.drawable.bg_compose_background),
        contentDescription = "푸른 배경 그림",
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun LearnTogetherTitle(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LearnTogetherContent(firstContent: String, secondContent: String) {
    Text(
        text = firstContent,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
    Text(
        text = secondContent,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun LearnTogetherPreview() {
    TutorialApplicationTheme {
        LearnTogetherColumn(
            stringResource(R.string.learn_together_title),
            stringResource(R.string.learn_together_first_content),
            stringResource(R.string.learn_together_second_content)
        )
    }
}


