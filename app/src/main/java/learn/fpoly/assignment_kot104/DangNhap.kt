package learn.fpoly.assignment_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import learn.fpoly.assignment_kot104.CustomButton
import learn.fpoly.assignment_kot104.R

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White).padding(top = 100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "_________________")
                }

                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(140.dp)
                        .padding(16.dp),
                    contentScale = ContentScale.Crop
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "_________________")
                }
            }

            Text(
                text = "Hello!",
                style = MaterialTheme.typography.button,
                color = Color.Gray
            )
            Text(
                text = "WELCOME BACK",
                style = MaterialTheme.typography.button,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.img_2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .padding(1.dp)
                            .background(Color.LightGray, shape = CircleShape),
                    )
                }
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Forgot Password",
                style = MaterialTheme.typography.button,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(10.dp))
            getLogin()
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "SIGN UP",
                style = MaterialTheme.typography.button,
                color = Color.Gray
            )
        }
    }
}
@Composable
fun getLogin() {
    androidx.compose.material.Button(
        onClick = { /* Handle checkout */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp)
            .padding(top = 5.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        androidx.compose.material.Text(text = "Đăng Nhập", color = Color.White)
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
