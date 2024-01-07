package com.example.itemslist.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itemslist.presentation.components.EditItemComponent
import com.example.itemslist.presentation.components.InsertItemComponent
import com.example.itemslist.presentation.viewmodel.ItemsViewModel

@Composable
fun ItemDetailScreen(
    itemId: Int = -1,
    onBackClick: () -> Unit,
    viewModel: ItemsViewModel = hiltViewModel()
) {

    if (itemId != -1) {

        EditItemComponent(viewModel, itemId, onBackClick)

    } else {

        InsertItemComponent(onBackClick, viewModel)

    }
}