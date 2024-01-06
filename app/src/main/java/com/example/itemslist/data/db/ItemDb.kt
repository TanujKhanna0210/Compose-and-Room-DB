package com.example.itemslist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itemslist.data.dao.ItemDao
import com.example.itemslist.domain.model.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class ItemDb : RoomDatabase() {

    abstract val itemDao: ItemDao

}