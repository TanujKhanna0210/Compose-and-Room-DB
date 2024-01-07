package com.example.itemslist.domain.repository

import com.example.itemslist.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getItems(): Flow<List<Item>>

    suspend fun getItem(itemId: Int): Item

    suspend fun insert(item: Item)

    suspend fun update(item: Item)

    suspend fun delete(item: Item)

}