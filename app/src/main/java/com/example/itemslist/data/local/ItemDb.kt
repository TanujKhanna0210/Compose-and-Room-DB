package com.example.itemslist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.itemslist.domain.model.Item

@Database(
    entities = [Item::class],
    version = 1
)
@TypeConverters(
    ItemTypeConverter::class
)
abstract class ItemDb : RoomDatabase() {

    abstract val itemDao: ItemDao

}