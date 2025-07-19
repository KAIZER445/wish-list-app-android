package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.dummyWish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
){
    val context = LocalContext.current
    Scaffold(
        topBar = { AppBarView(title = "Wish List", {
            Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show()
        }) },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                contentColor = Color.White,
                containerColor = Color.Black,
                onClick = {
                navController.navigate(Screen.AddScreen.route)
                },

                ) {

                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "add description")

            }
        }
    ) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(it) ){
                    items(dummyWish.wishlist){
                        wish -> WishItem(wish = wish) {
                        
                    }
                }
            }
    }
}

@Composable
fun WishItem(wish: Wish, onclick: ()->Unit){
    Card(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .clickable {
                onclick()
            },
            elevation = 10.dp,
            backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}