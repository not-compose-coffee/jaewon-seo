package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleted.ui.theme.TaskCompletedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCompletedScreen(stringResource(id = R.string.all_task_completed), stringResource(id = R.string.nice_work))
        }
    }
}

@Composable
fun TaskCompletedScreen(
    allTaskCompleted: String,
    niceWork: String,
    modifier: Modifier = Modifier) {
    Column(
        modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = "Task Compelete",
        )
        Text(
            text = allTaskCompleted,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 24.dp,
                bottom = 8.dp
            )
        )
        Text(
            text = niceWork + " Jaewon",
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() { }