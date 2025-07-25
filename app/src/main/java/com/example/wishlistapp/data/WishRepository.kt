package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish: Wish){
        wishDao.addWish(wish)
    }

    fun getWish(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id: Long) :Flow<Wish> {
        return wishDao.getWishFromId(id)
    }

    suspend fun updateWish(wish:Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}