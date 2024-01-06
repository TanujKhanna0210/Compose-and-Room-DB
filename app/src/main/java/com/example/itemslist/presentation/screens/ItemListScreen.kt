package com.example.itemslist.presentation.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.itemslist.domain.model.Item
import com.example.itemslist.presentation.components.ItemCard
import com.example.itemslist.presentation.components.TopBar
import com.example.itemslist.ui.theme.ItemsListTheme
import com.example.itemslist.util.Dimens.SmallPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(
    navController: NavController,
    items: List<Item>,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxSize()
    ) {

        Scaffold(
            topBar = {
                TopBar(title = "Item List",
                    onBackClick = { navController.navigateUp() })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /* TODO: Handle navigation */
                    navController.navigate("")
                }) {
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
                    ItemCard(item = item, navController = navController)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ItemListScreenPreview() {
    ItemsListTheme {
        ItemListScreen(
            navController = rememberNavController(),
            items =
            listOf<Item>(
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                ),
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                ),
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                ),
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                ),
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                ),
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                ),
                Item(
                    name = "Refrigerator",
                    qty = "4",
                    rating = "5",
                    remarks = "Excellent product.\nHighly recommended."
                )
            )

        )
    }
}