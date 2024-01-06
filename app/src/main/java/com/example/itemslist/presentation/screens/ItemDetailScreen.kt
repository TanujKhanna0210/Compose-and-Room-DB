package com.example.itemslist.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ItemDetailScreen(
    itemId: Int = -1,
    onBackClick: () -> Unit
) {
    Text(text = "Item Details")
}