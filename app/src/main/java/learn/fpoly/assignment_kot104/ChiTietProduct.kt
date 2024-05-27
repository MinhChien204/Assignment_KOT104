package learn.fpoly.assignment_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductScreen() {
    var quantity by remember { mutableStateOf(1) }
    var selectedColor by remember { mutableStateOf(Color.Gray) }

    val colors = listOf(
        Color.Gray,
        Color(0xFFD2A277),
        Color(0xFFE3CAA5)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            // Image and back button
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_12),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .clip(RoundedCornerShape(bottomStart = 100.dp)),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { /* Handle back button click */ },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .size(40.dp),
                        imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Back"
                    )
                }
            }

            // Product details
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Product title
                Text(
                    text = "Minimal Stand",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Price and quantity controls
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    // Price
                    Text(
                        text = "$50",
                        style = MaterialTheme.typography.h4.copy(fontSize = 30.sp),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    // Quantity controls
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { if (quantity > 1) quantity-- }) {
                            Icon(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color.LightGray),
                                imageVector = Icons.Outlined.Remove, contentDescription = "Decrease"
                            )
                        }
                        Text(text = "$quantity", style = MaterialTheme.typography.h6)
                        IconButton(onClick = { quantity++ }) {
                            Icon(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color.LightGray),
                                imageVector = Icons.Outlined.Add, contentDescription = "Increase"
                            )
                        }
                    }
                }

                // Rating
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Rating",
                        tint = Color.Yellow
                    )
                    Text(
                        text = "4.5 (50 reviews)",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                // Product description
                Text(
                    text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Add to cart button
                Button(
                    onClick = { /* Handle add to cart */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text(text = "Add to cart", color = Color.White)
                }
            }
        }

        // Color selection
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color)
                        .clickable { selectedColor = color }
                        .border(
                            width = 2.dp,
                            color = if (color == selectedColor) Color.Black else Color.Transparent,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}
