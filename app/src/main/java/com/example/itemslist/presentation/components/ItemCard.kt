package com.example.itemslist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.itemslist.domain.model.Item
import com.example.itemslist.util.Dimens
import com.example.itemslist.util.Dimens.IconSize2
import com.example.itemslist.util.Dimens.MediumPadding
import com.example.itemslist.util.Dimens.SmallPadding

@Composable
fun ItemCard(
    item: Item,
    navigateToDetailsScreen: (itemId: Int) -> Unit,
    onDelete: () -> Unit
) {
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(MediumPadding)
                .clickable {
                    navigateToDetailsScreen(item.itemId)
                },
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(MediumPadding)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Item: ${item.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = "Qty: ${item.qty}",
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(SmallPadding))

                Text(
                    text = "Ratings: ${item.rating}",
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                if (item.remarks?.isNotEmpty() == true) {

                    Spacer(modifier = Modifier.height(SmallPadding))

                    Text(
                        text = "Remarks: ${item.remarks}",
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier
                .padding(end = Dimens.MediumPadding2, bottom = Dimens.MediumPadding2)
                .size(IconSize2)
                .align(Alignment.BottomEnd)
                .clickable {
                    onDelete()
                }
        )
    }
}