package com.example.itemslist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.itemslist.domain.model.Item
import com.example.itemslist.ui.theme.ItemsListTheme
import com.example.itemslist.util.Dimens.MediumPadding
import com.example.itemslist.util.Dimens.SmallPadding

@Composable
fun ItemCard(
    item: Item,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(MediumPadding)
            .clickable {
                navController.navigate("") //TODO: Handle navigation
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
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "Qty: ${item.qty}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(SmallPadding))

            Text(
                text = "Ratings: ${item.rating}",
                style = MaterialTheme.typography.bodyLarge
            )

            if (item.remarks != null) {

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
}

@Preview(showBackground = true)
@Composable
fun ItemCardPreview() {
    ItemsListTheme {
        ItemCard(
            item = Item(
                name = "Refrigerator",
                qty = "4",
                rating = "5",
                remarks = "Excellent product.\nHighly recommended."
            ),
            navController = rememberNavController()
        )
    }
}