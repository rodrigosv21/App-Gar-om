package com.example.appgarcom.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appgarcom.R

@SuppressLint("MutableCollectionMutableState")
@Composable
fun MenuItem() {
    val menuItems = listOf("Pizzas", "Drinks", "Desserts")

    var selectedItem by rememberSaveable {
        mutableStateOf(menuItems.first())
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.padding(8.dp)) {
            menuItems.forEach { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { selectedItem = item },
                    fontWeight = if (selectedItem == item) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
        when (selectedItem) {
            "Pizzas" -> {
                Items()
            }

            "Drinks" -> {
                Text("Drinks list")
            }

            "Desserts" -> {
                Text("List of desserts")
            }
        }
    }
}

@Composable
private fun Items() {

    var amount by remember { mutableIntStateOf(0) }
    var btndecrement by remember { mutableStateOf(false) }

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {

            Row(
                modifier = Modifier.padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_inicio),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 7.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Pizza Calabresa",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "R$ 30,00",
                        fontSize = 14.sp
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        enabled = btndecrement,
                        onClick = {
                            amount--
                            if (amount < 1) {
                                btndecrement = false
                            }

                        }
                    ) {
                        Icon(Icons.Outlined.Clear, contentDescription = null)
                    }

                    Text(text = amount.toString())

                    IconButton(
                        onClick = {
                            amount++
                            btndecrement = true

                        },
                    ) {
                        Icon(Icons.Outlined.Add, contentDescription = null)
                    }
                }
            }
        }

        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
            Button(enabled = true,
                onClick = {
                    btndecrement = true
                }, modifier = Modifier
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.Center
                ) {
                    Icon(Icons.Outlined.ShoppingCart, contentDescription = null)
                    Text(text = "Review Order-${amount}-")
                }
            }


        }
    }
}

@Preview
@Composable
private fun MenuItemsPreview() {
    MenuItem()
}