package com.example.itemslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.itemslist.presentation.navigation.NavGraph
import com.example.itemslist.ui.theme.ItemsListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemsListTheme {
                NavGraph()
            }
        }
    }
}