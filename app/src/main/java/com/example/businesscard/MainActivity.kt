package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CardCenter(modifier = Modifier.weight(1f))
        CardBottom(modifier = Modifier.weight(0.25f))
    }
}
@Composable
fun CardCenter(modifier: Modifier = Modifier) {
    val profile = painterResource(R.drawable.icon_profile)
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = profile,
            contentDescription = stringResource(R.string.image_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Text(
            text = "Cranston Parker",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Desperately seeking employment",
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CardBottom(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){
        CardItem(
            icon = painterResource(R.drawable.github_mark),
            iconDesc = "Github",
            text= "https://github.com/TheForce172"
            )
        CardItem(
            icon = painterResource(R.drawable.gmail_icon__2020_),
            iconDesc = "Email",
            text = "theforce172@gmail.com"
        )
        CardItem(
            icon = painterResource(R.drawable.logo),
            iconDesc = "X",
            text = "@theforce172"
        )
    }

}

@Composable
fun CardItem(icon: Painter, iconDesc: String, text: String, modifier: Modifier = Modifier){
    Row(modifier = modifier.padding(8.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        Icon(
            painter = icon,
            contentDescription = iconDesc,
            modifier = Modifier
                .size(28.dp)

        )
        Text(
            text = text,
            fontSize = 20.sp,
            modifier= Modifier.padding( start = 12.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BusinessCardTheme {
        MainScreen()
    }
}