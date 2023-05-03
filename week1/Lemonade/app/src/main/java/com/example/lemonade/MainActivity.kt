package com.example.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                ComposeLemonadeApp()
            }
        }
    }
}

@Composable
fun Lemonade(
    tree_comment: String,
    lemon_comment : String,
    lemonade_comment: String,
    glass_comment: String,
    tree_desc : String,
    lemon_desc : String,
    lemonade_desc : String,
    glass_desc : String,
    tree_image: Painter,
    lemon_image: Painter,
    lemonade_image :Painter,
    glass_image:Painter,
    modifier: Modifier = Modifier) {

    var comment : String = tree_comment
    var image : Painter =tree_image
    var desc : String = tree_desc

    var random = remember { mutableStateOf(0) }
    var cnt = remember { mutableStateOf(0) }

    when(cnt.value) {
        0 -> { comment = tree_comment; image = tree_image;desc = tree_desc; random.value = (1..10).random()}
        in 1..2+random.value-1 -> { comment = lemon_comment; image = lemon_image ; ;desc = lemon_desc}
        2+random.value -> { comment = lemonade_comment; image = lemonade_image; desc = lemonade_desc}
        2+random.value+1 -> { comment = glass_comment; image = glass_image; desc = glass_desc;}
        2+random.value+2 -> {cnt.value=0}
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text(
            text = comment,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painter = image,
            contentDescription = desc,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.skyblue),
                    shape = RectangleShape
                )
                .clickable { cnt.value += 1 }

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeLemonadeApp() {
    Lemonade(
        stringResource(id = R.string.tree_comment),
        stringResource(id = R.string.lemon_comment),
        stringResource(id = R.string.lemonade_comment),
        stringResource(id = R.string.glass_comment),
        stringResource(id = R.string.tree_desc),
        stringResource(id = R.string.lemon_desc),
        stringResource(id = R.string.lemonade_desc),
        stringResource(id = R.string.glass_desc),
        painterResource(id = R.drawable.lemon_tree),
        painterResource(id = R.drawable.lemon_squeeze),
        painterResource(id = R.drawable.lemon_drink),
        painterResource(id = R.drawable.lemon_restart)
    )
}