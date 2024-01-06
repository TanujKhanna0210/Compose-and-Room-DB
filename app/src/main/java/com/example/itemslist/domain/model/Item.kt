package com.example.itemslist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true) val itemId: Int,
    val name: String,
    val qty: String,
    val rating: String,
    val remarks: String?
)
