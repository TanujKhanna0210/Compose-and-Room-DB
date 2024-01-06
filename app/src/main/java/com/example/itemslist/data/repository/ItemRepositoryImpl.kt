package com.example.itemslist.data.repository

import com.example.itemslist.data.dao.ItemDao
import com.example.itemslist.domain.model.Item
import com.example.itemslist.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(
    private val itemDao: ItemDao
) : ItemRepository {
    override fun getItems(): Flow<List<Item>> {
        return itemDao.getItems()
    }

    override suspend fun getItem(itemId: Int): Item {
        return itemDao.getItem(itemId)
    }

    override suspend fun upsert(item: Item) {
        itemDao.upsert(item)
    }

    override suspend fun delete(item: Item) {
        itemDao.delete(item)
    }
}