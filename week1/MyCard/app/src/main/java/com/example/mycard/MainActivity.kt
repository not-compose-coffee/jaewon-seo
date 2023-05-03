package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                ComposeMyCardApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeMyCardApp() {
    MyCard(name = stringResource(id = R.string.name), 
        job = stringResource(id = R.string.job) , 
        phonenumber = stringResource(id = R.string.phonenumber), 
        instagram = "@" + stringResource(id = R.string.instagram) , 
        email = stringResource(id = R.string.email) , 
        imagePainter = painterResource(id = R.drawable.ic_launcher_foreground))
}

@Composable
fun MyCard(
    name: String,
    job: String,
    phonenumber: String,
    instagram: String,
    email: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF103650)),) {

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(3f, false),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop,
                    painter = imagePainter,
                    contentDescription = stringResource(id = R.string.desc_android)
                )
                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 50.sp,
                    modifier = Modifier.padding(
                        bottom = 16.dp,
                    )
                )
                Text(
                    text = job,
                    color = Color(0xFF3ddc84),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f, false),
                verticalArrangement = Arrangement.Bottom) {

                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()  //fill the max height
                        .width(1.dp)
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(
                        Icons.Rounded.Phone,
                        tint = Color(0xFF3ddc84),
                        contentDescription = stringResource(id = R.string.desc_phone),
                        modifier = Modifier.weight(1.5f))
                    Text(
                        text = phonenumber,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(3.5f)
                    )
                }

                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()  //fill the max height
                        .width(1.dp)
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(
                        Icons.Rounded.Share,
                        tint = Color(0xFF3ddc84),
                        contentDescription = stringResource(id = R.string.desc_share),
                        modifier = Modifier.weight(1.5f))
                    Text(
                        text = instagram,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(3.5f)
                    )
                }
                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()  //fill the max height
                        .width(1.dp)
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(
                        Icons.Rounded.Email,
                        tint = Color(0xFF3ddc84),
                        contentDescription = stringResource(id = R.string.desc_mail),
                        modifier = Modifier.weight(1.5f))
                    Text(
                        text = email,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(3.5f)
                    )
                }
            }
            
        }

    }

