package com.example.wishlistapp

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun addeditdetailview(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
){
    Scaffold(
        topBar = { AppBarView(title = if (id != 0L)
            stringResource(R.string.update_wish)
        else

            stringResource(R.string.add_wish)
        )
        { navController.navigateUp() }
                 }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Title",
                value = viewModel.wishTitleState,
                onValueChangeListener = {viewModel.onWishTitleChange(it)})

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChangeListener = {viewModel.onWishDescriptionChange(it)})

            Spacer(modifier = Modifier.height(10.dp))
            
            Button(onClick = { /*TODO*/ }) {
                if (id != 0L) {
                    Text(text = "Update Wishlist")
                }else{
                    Text(text = "Add Wishlist")
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChangeListener: (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChangeListener,
        label = { Text(text = label, color = Color.Black)},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedTextColor = colorResource(id = R.color.black),
            focusedTextColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black)
        )
    )


}

@Preview
@Composable
fun WishTextFieldPrev(){
    WishTextField(label = "Text", value = "Text", onValueChangeListener = {})
}