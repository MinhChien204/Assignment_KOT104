package learn.fpoly.assignment_kot104

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun FavoritesScreen() {
    val selectedItem = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
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
                        text = "Favorites",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 16.dp)
                    )

                    IconButton(onClick = { /* Handle cart */ }) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(favoriteItems) { item ->
                    FavoriteItem(item = item)
                }
            }
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Button(
                onClick = { /* Handle checkout */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 10.dp) // Add bottom padding to avoid overlap with BottomNavigation
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(text = "Add all to my cart", color = Color.White)
            }

            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White,
                contentColor = Color.Black
            ) {
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
                    selected = selectedItem.value == 2,
                    onClick = { selectedItem.value = 2 },
                    alwaysShowLabel = false
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    selected = selectedItem.value == 3,
                    onClick = { selectedItem.value = 3 },
                    alwaysShowLabel = false
                )
            }
        }
    }
}

@Composable
fun FavoriteItem(item: FavoriteItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f))
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = item.name, style = MaterialTheme.typography.subtitle1)
                Text(text = "$${item.price}", style = MaterialTheme.typography.body2)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            IconButton(onClick = { /* Handle remove from favorites */ }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Remove")
            }
            IconButton(onClick = { /* Handle add to cart */ }) {
                Icon(imageVector = Icons.Default.ShoppingBag, contentDescription = "Add to cart")
            }
        }
    }
}

data class FavoriteItem(
    @DrawableRes val imageRes: Int,
    val name: String,
    val price: Double
)

val favoriteItems = listOf(
    FavoriteItem(R.drawable.img_11, "Coffee Table", 50.00),
    FavoriteItem(R.drawable.img_12, "Coffee Chair", 20.00),
    FavoriteItem(R.drawable.img_13, "Minimal Stand", 25.00),
    FavoriteItem(R.drawable.img_14, "Minimal Desk", 50.00),
    FavoriteItem(R.drawable.img_10, "Minimal Lamp", 12.00)
)

@Preview
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}

@Composable
fun BottomNavigationCt(selectedItem: MutableState<Int>, modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
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
            selected = selectedItem.value == 2,
            onClick = { selectedItem.value = 2 },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            selected = selectedItem.value == 3,
            onClick = { selectedItem.value = 3 },
            alwaysShowLabel = false
        )
    }
}
