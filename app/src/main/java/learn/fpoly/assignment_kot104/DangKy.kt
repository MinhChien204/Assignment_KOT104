package learn.fpoly.assignment_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DangKy : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterScreen(onRegister = { email, password, confirmPassword ->
                // Handle registration logic here
            })
        }
    }
}

@Composable
fun RegisterScreen(onRegister: (String, String, String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 60.dp)
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

            Text(text = "Welcome", style = MaterialTheme.typography.button)
            Spacer(modifier = Modifier.height(32.dp))
            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
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
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
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
            Spacer(modifier = Modifier.height(32.dp))
            CustomButton(onClick = { onRegister(email, password, confirmPassword) }, text = "Register")
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "I don't have an account? Log in",
                style = MaterialTheme.typography.button,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun CustomButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Text(text = text, color = Color.White, fontSize = 16.sp, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(onRegister = { _, _, _ -> })
}
