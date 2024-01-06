package com.example.itemslist.domain.repository

import com.example.itemslist.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getItems(): Flow<List<Item>>

    suspend fun getItem(itemId: Int): Item

    suspend fun upsert(item: Item)

    suspend fun delete(item: Item)

}