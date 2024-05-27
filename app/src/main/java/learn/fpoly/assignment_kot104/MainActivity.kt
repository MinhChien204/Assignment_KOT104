package learn.fpoly.assignment_kot104

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun ManHinhChinh() {
    val selectedItem = mutableStateOf(0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
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
                        text = "Home Beautiful",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.weight(1f).padding(horizontal = 16.dp)
                    )

                    IconButton(onClick = { /* Handle cart */ }) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                }
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            modifier = Modifier.padding(top = 60.dp) // Khoảng cách giữa các item
        ) {
            items(androidNameList) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(60.dp)) // Bo tròn với bán kính 60.dp
                            .background(Color.LightGray) // Áp dụng màu nền
                            .padding(7.dp) // Thêm padding bên trong nền bo tròn
                    ) {
                        Image(
                            modifier = Modifier.size(35.dp),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = item.imageResourceId),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp) // Thêm khoảng cách giữa ảnh và text
                    )
                }
            }
        }

        // Place the LazyVerticalGrid below the LazyRow
        Column(
            modifier = Modifier
                .padding(top = 150.dp)
                .align(Alignment.TopCenter)
        ) {
            LazyVerticalGrid(GridCells.Fixed(2)) {
                items(listproduct) { item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(220.dp)
                                .padding(10.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = item.imageId),
                            contentDescription = null
                        )
                        Text(
                            text = item.nameProduct,
                            style = MaterialTheme.typography.button,
                            modifier = Modifier.padding(top = 3.dp) // Add spacing between image and text
                        )
                        Text(
                            text = item.price,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(top = 5.dp) // Add spacing between name and price
                        )
                    }
                }
            }
        }

        // Add Bottom Navigation
        BottomNavigationContent(selectedItem)
    }
}

data class AndroidVersion(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val release: String
)

val androidNameList = listOf(

    AndroidVersion(R.drawable.img_5, "Popular", "October 5, 2015"),
    AndroidVersion(R.drawable.img_6, "Chair", "August 22, 2016"),
    AndroidVersion(R.drawable.img_7, "Table", "August 21, 2017"),
    AndroidVersion(R.drawable.img_8, "Aimchair", "August 6, 2018"),
    AndroidVersion(R.drawable.img_9, "Bed", "September 3, 2019"),
    AndroidVersion(R.drawable.img_10, "Lamp", "September 8, 2020")
)

data class AndroidVer(
    @DrawableRes val imageId: Int,
    val nameProduct: String,
    val price: String
)

val listproduct = listOf(

    AndroidVer(R.drawable.img_11, "Black Simple Lamp", "100.000 vnd"),
    AndroidVer(R.drawable.img_12, "Minimal Stand", "200.000 vnd"),
    AndroidVer(R.drawable.img_13, "Coffee Chair", "300.000 vnd"),
    AndroidVer(R.drawable.img_14, "Simple Desk", "400.000 vnd"),
    AndroidVer(R.drawable.img_11, "Simple Desk", "400.000 vnd"),
    AndroidVer(R.drawable.img_12, "Simple Desk", "400.000 vnd"),

)

@Preview
@Composable
fun ManChinhPreview() {
    ManHinhChinh()
}
