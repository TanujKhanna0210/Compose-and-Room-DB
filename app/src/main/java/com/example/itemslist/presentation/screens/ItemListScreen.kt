package com.example.itemslist.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itemslist.presentation.components.ItemCard
import com.example.itemslist.presentation.components.TopBar
import com.example.itemslist.presentation.viewmodel.ItemsViewModel
import com.example.itemslist.util.Dimens.SmallPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    navigateToDetailsScreen: (itemId: Int) -> Unit,
    onBackCLick: () -> Unit,
    viewModel: ItemsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val items by viewModel.getItems().collectAsState(
        initial = emptyList()
    )

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier.fillMaxSize()
    ) {

        Scaffold(
            topBar = {
                TopBar(
                    title = "Item List",
                    onBackClick = onBackCLick
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navigateToDetailsScreen(-1) }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add item"
                    )
                }
            }
        ) {
            val topPadding = it.calculateTopPadding()
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = topPadding),
                verticalArrangement = Arrangement.spacedBy(SmallPadding),
                contentPadding = PaddingValues(SmallPadding)
            ) {
                items(count = items.size) { index ->
                    val item = items[index]
                    ItemCard(item = item, navigateToDetailsScreen = {
                        navigateToDetailsScreen(item.itemId)
                    })
                }
            }
        }

    }
}