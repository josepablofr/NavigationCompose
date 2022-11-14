package com.example.navigationcompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.Screen
import com.example.navigationcompose.data.Fruit
import com.example.navigationcompose.data.fruitList

@Composable
fun FruitScreen(navController: NavController, fruitList: List<Fruit>) {
    LazyColumn{
        items(fruitList) { fruit ->
            FruitItem(fruit = fruit, onFruitClick = {
                navController.navigate(Screen.FruitDetailScreen.route + "/${fruit.id}")
            })
        }
    }
}

@Composable
fun FruitItem(fruit: Fruit, onFruitClick: (fruit: Fruit) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(modifier = Modifier
            .padding(start = 4.dp)
            .clickable {
                onFruitClick(fruit)
            },
        text = fruit.name)
    }
    Divider()
}

@Preview(showBackground = true)
@Composable
private fun FruitItemPreview() {
    Column(modifier = Modifier.padding(8.dp)) {
        FruitItem(fruit = fruitList[0], onFruitClick = {})
        FruitItem(fruit = fruitList[1], onFruitClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun FruitScreenPreview() {
  FruitScreen(navController = rememberNavController(), fruitList)
}
