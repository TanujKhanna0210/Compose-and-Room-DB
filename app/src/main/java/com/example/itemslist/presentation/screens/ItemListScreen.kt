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
import androidx.compose.ui.Modifier
import com.example.itemslist.domain.model.Item
import com.example.itemslist.presentation.components.ItemCard
import com.example.itemslist.presentation.components.TopBar
import com.example.itemslist.util.Dimens.SmallPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    navigateToDetailsScreen: (itemId: Int) -> Unit,
    onBackCLick: () -> Unit,
    items: List<Item>,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxSize()
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