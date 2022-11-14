package com.example.navigationcompose.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.data.Fruit
import com.example.navigationcompose.data.findFruit
import com.example.navigationcompose.data.fruitList

@Composable
fun FruitDetailScreen(navController: NavController, fruit: Fruit?) {

    if(fruit != null) {
        Text(text = fruit.name)
    } else {
        navController.popBackStack()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFruitDetailScreen() {
    FruitDetailScreen(navController = rememberNavController(), fruitList[2])
}
