package com.example.itemslist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.itemslist.ui.theme.ItemsListTheme

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    initialRating: Int = 0,
    stars: Int = 5,
    starColor: Color = MaterialTheme.colorScheme.onBackground,
    onRatingChange: (Int) -> Unit
) {

    var rating by remember {
        mutableIntStateOf(initialRating)
    }

    Row {
        for (index in 1..stars) {
            Icon(
                imageVector = if (index <= rating) Icons.Filled.StarRate else Icons.Outlined.StarRate,
                contentDescription = null,
                tint = starColor,
                modifier = modifier.clickable {
                    onRatingChange(index)
                    rating = index
                }
            )
        }
    }

}

@Preview
@Composable
fun RatingBarPreview() {
    ItemsListTheme {
        RatingBar(
            onRatingChange = {}
        )
    }
}