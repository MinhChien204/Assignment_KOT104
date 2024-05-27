package learn.fpoly.assignment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ManHinhChao : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(top = 300.dp),
        ) {
            androidx.compose.material.Text(
                text = "Home Beautiful",
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp).padding(10.dp),
                style = MaterialTheme.typography.button
            )
            Text(
                text = buildAnnotatedString {
                    append("The best simple place where you discover most wonderful furnitures and ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    }
                    append(" home beautiful")
                },
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight(400),

                modifier = Modifier.padding(bottom = 16.dp, top = 30.dp),
                textAlign = TextAlign.Center
            )
            GetButton()
        }
    }
}

@Composable
fun GetButton() {
    androidx.compose.material.Button(
        onClick = { /* Handle checkout */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp)
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        androidx.compose.material.Text(text = "Get Started", color = Color.White)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen()
}
