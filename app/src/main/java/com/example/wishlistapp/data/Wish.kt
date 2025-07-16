package com.example.wishlistapp.data

data class Wish(
    val id : Long = 0L,
    val title : String = "",
    val description : String = ""
)

object dummyWish {
    val wishlist = listOf(
        Wish(title = "Google Watch Pixel 2", description = "An android watch"),
        Wish(title = "Google Watch Pixel 2", description = "An android watch"),
        Wish(title = "Google Watch Pixel 2", description = "An android watch"),
    )
}