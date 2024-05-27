package learn.fpoly.assignment_kot104

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.RemoveCircleOutline
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartScreen() {
    var total by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "My Cart",
                    style = MaterialTheme.typography.button,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 90.dp)
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            },
            backgroundColor = Color.White, // Đặt màu nền của TopAppBar thành màu trắng
            contentColor = Color.Black // Đặt màu chữ của TopAppBar thành màu trắng
        )



        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(cartItems) { item ->
                CartItem(item = item) { newTotal ->
                    total = newTotal
                }
            }
        }

        PromoCodeSection()
        TotalAmountSection(total = total)
        CheckoutButton()
    }
}

@Composable
fun CartItem(item: CartItem, onTotalChange: (Double) -> Unit) {
    var quantity by remember { mutableStateOf(1) }

    fun updateTotal() {
        onTotalChange(cartItems.sumOf { it.price * quantity })
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.2f))
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = item.name, style = MaterialTheme.typography.button)
            Text(text = "$${item.price}", style = MaterialTheme.typography.button)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { if (quantity > 1) quantity--; updateTotal() }) {
                    Icon(modifier = Modifier.clip(RoundedCornerShape(5.dp)).background(Color.LightGray),
                        imageVector = Icons.Outlined.Remove, contentDescription = "Decrease")
                }
                Text(text = "$quantity", style = MaterialTheme.typography.body2)
                IconButton(onClick = { quantity++; updateTotal() }) {
                    Icon(modifier = Modifier.clip(RoundedCornerShape(5.dp)).background(Color.LightGray),
                        imageVector = Icons.Outlined.Add, contentDescription = "Increase")
                }
            }
        }
        IconButton(onClick = { /* Handle remove from cart */ }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Remove")
        }
    }
}

@Composable
fun PromoCodeSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.LightGray.copy(alpha = 0.2f))
            .clip(RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        TextField(
            value = "",
            onValueChange = { /* Handle promo code change */ },
            placeholder = { Text("Enter your promo code") },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        IconButton(
            onClick = { /* Handle apply promo code */ },
            modifier = Modifier
                .background(Color.Black, RoundedCornerShape(20.dp))
                .padding(8.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Apply",
                tint = Color.White
            )
        }

    }
}

@Composable
fun TotalAmountSection(total: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Total:", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
        Text(text = "$${total}", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CheckoutButton() {
    Button(
        onClick = { /* Handle checkout */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
    ) {
        Text(text = "Check out", color = Color.White)
    }

}

data class CartItem(
    @DrawableRes val imageRes: Int,
    val name: String,
    val price: Double
)

val cartItems = listOf(
    CartItem(R.drawable.img_12, "Minimal Stand", 25.00),
    CartItem(R.drawable.img_11, "Coffee Table", 20.00),
    CartItem(R.drawable.img_14, "Minimal Desk", 50.00)
)

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen()
}
