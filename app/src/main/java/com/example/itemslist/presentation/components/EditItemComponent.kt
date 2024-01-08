package com.example.itemslist.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.itemslist.domain.model.Item
import com.example.itemslist.presentation.viewmodel.ItemsViewModel
import com.example.itemslist.util.Constants
import com.example.itemslist.util.Dimens

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
fun EditItemComponent(
    viewModel: ItemsViewModel,
    itemId: Int,
    onBackClick: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getItem(itemId)
    }

    val name = viewModel.item.name
    val qty = viewModel.item.qty
    val rating = viewModel.item.rating
    val remarks = viewModel.item.remarks
    val images = viewModel.item.images

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar(
                title = Constants.ITEM_DETAILS_SCREEN,
                onBackClick = onBackClick
            )
        }
    ) {
        val topPadding = it.calculateTopPadding()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = topPadding + Dimens.MediumPadding,
                    start = Dimens.MediumPadding,
                    end = Dimens.MediumPadding,
                    bottom = Dimens.MediumPadding
                )
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Photos:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(Dimens.SmallPadding))

//                val existingImages = viewModel.fetchExistingImages()
//
//                // Log.d("TAG_TAG", existingImages.size.toString())
//
//                viewModel.updateImages(images)
//
//                PickMultipleImagesFromCamera(images = remember { mutableStateListOf(*existingImages.toTypedArray()) })

            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Item Name:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.width(80.dp)
                )

                Spacer(modifier = Modifier.width(Dimens.VerySmallPadding))

                val keyboardController = LocalSoftwareKeyboardController.current
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        if (it.length <= 15) {
                            viewModel.updateName(it)
                        }
                    },
                    placeholder = {
                        Text(
                            text = "*required",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )
            }


            Spacer(modifier = Modifier.height(Dimens.MediumPadding))

            Row(
                modifier = Modifier
                    .fillMaxWidth(.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Quantity:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.width(80.dp)
                )

                Spacer(modifier = Modifier.width(Dimens.VerySmallPadding))

                val keyboardController = LocalSoftwareKeyboardController.current
                OutlinedTextField(
                    value = qty,
                    onValueChange = {
                        if (it.length <= 4) {
                            viewModel.updateQty(it)
                        }
                    },
                    placeholder = {
                        Text(
                            text = "*required",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding))

            Row(
                modifier = Modifier
                    .fillMaxWidth(.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ratings:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.width(80.dp)
                )

//                Spacer(modifier = Modifier.width(Dimens.VerySmallPadding))
//
//                RatingBar(
//                    modifier = Modifier.size(Dimens.IconSize),
//                    initialRating = rating,
//                    onRatingChange = { r ->
//                        viewModel.updateRating(r.toString())
//                    })

                val keyboardController = LocalSoftwareKeyboardController.current
                OutlinedTextField(
                    value = rating,
                    onValueChange = {
                        if (it.length <= 1) {
                            viewModel.updateRating(it)
                        }
                    },
                    placeholder = {
                        Text(
                            text = "*required",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Remarks:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(Dimens.SmallPadding))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    value = remarks ?: "",
                    onValueChange = {
                        if (it.length <= 200) {
                            viewModel.updateRemarks(it)
                        }
                    },
                    placeholder = {
                        Text(
                            text = "optional",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    textStyle = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(Dimens.MediumPadding))

            Button(
                onClick = {
                    if (name.isNotEmpty() && qty.isNotEmpty() && rating.isNotEmpty()) {
                        val item = Item(
                            itemId = itemId,
                            name = name,
                            qty = qty,
                            rating = rating,
                            remarks = remarks,
                            images = emptyList()
                        )
                        viewModel.updateItem(item)
                        onBackClick()
                    } else {
                        Toast.makeText(
                            context,
                            "Please enter the required fields!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.MediumPadding)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(Dimens.SmallPadding))
                    Text("Save")
                }
            }
        }
    }
}