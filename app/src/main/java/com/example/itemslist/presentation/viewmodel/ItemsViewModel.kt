package com.example.itemslist.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itemslist.domain.model.Item
import com.example.itemslist.domain.repository.ItemRepository
import com.example.itemslist.util.Constants.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    var item by mutableStateOf(
        Item(-1, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING)
    )
        private set

    fun getItems() = repository.getItems()

    fun getItem(itemId: Int) = viewModelScope.launch {
        item = repository.getItem(itemId)
    }

    fun upsertItem(item: Item) = viewModelScope.launch {
        repository.upsert(item)
    }

    fun deleteBook(item: Item) = viewModelScope.launch {
        repository.delete(item)
    }

}