package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title : String = "",
    @ColumnInfo(name = "wish-description")
    val description : String = ""
)

object dummyWish {
    val wishlist = listOf(
        Wish(title = "Google Watch Pixel 2", description = "An android watch"),
        Wish(title = "Google Watch Pixel 2", description = "An android watch"),
        Wish(title = "Google Watch Pixel 2", description = "An android watch"),
    )
}