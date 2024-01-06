package com.example.itemslist.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itemslist.domain.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM Item")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE itemId=:itemId")
    suspend fun getItem(itemId: Int): Item

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Item)

    @Delete
    suspend fun delete(item: Item)

}