package learn.fpoly.assignment_kot104

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Person

@Composable
fun BottomNavigationContent(selectedItem: MutableState<Int>, modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier = modifier
            .fillMaxWidth() // Fill the width of its parent
            .padding(top = 800.dp), // Add padding to the bottom
        backgroundColor = Color.White,
        contentColor = Color.Black
    ){
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = selectedItem.value == 0,
            onClick = { selectedItem.value = 0 },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
            selected = selectedItem.value == 1,
            onClick = { selectedItem.value = 1 },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.NotificationsActive, contentDescription = "Notification") },
            selected = selectedItem.value == 1,
            onClick = { selectedItem.value = 1 },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            selected = selectedItem.value == 2,
            onClick = { selectedItem.value = 2 },
            alwaysShowLabel = false
        )
    }
}

