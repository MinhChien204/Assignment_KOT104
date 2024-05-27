import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import learn.fpoly.assignment_kot104.BottomNavigationContent
import learn.fpoly.assignment_kot104.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun Screen() {
    val selectedItem = mutableStateOf(0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            TopBar()
            UserProfile()
        }
        BottomNavigationContent(selectedItem)
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = Color.White,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* Handle search */ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }

            Text(
                text = "Profile",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            IconButton(onClick = { /* Handle logout */ }) {
                Icon(imageVector = Icons.Default.Logout, contentDescription = "Logout")
            }
        }
    }
}

@Composable
fun UserProfile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.img_17),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Minh Chiến", style = MaterialTheme.typography.h6)
                Text(
                    text = "nmchien2204@gmail.com",
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        ProfileOptionCard(title = "My orders")
        ProfileOptionCard(title = "Shipping Address")
        ProfileOptionCard(title = "Payment Methods")
        ProfileOptionCard(title = "Reviews")
    }
}

@Composable
fun ProfileOptionCard(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable { /* Handle click */ },
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    Screen()
}
