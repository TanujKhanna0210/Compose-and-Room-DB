package com.example.itemslist.presentation.components

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import com.example.itemslist.util.Dimens.ImageSize
import com.example.itemslist.util.Dimens.MediumPadding
import com.example.itemslist.util.Dimens.SmallPadding
import com.example.itemslist.util.Dimens.VerySmallPadding

@Composable
fun PickMultipleImagesFromCamera(images: SnapshotStateList<Bitmap>) {

    var selectedImage by remember { mutableStateOf<Bitmap?>(null) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) {
            it?.let { bitmap ->
                images.add(bitmap)
            }
        }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(MediumPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (images.isEmpty()) Arrangement.Center else Arrangement.Start
    ) {

        Button(onClick = { launcher.launch() }) {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "Capture image"
            )
            if (images.isEmpty()) {
                Spacer(modifier = Modifier.width(SmallPadding))
                Text("Add Photo")
            }
        }

        Spacer(modifier = Modifier.width(MediumPadding))
        
        LazyRow {
            items(images.size) { index ->
                val image = images[index]

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier.clickable {
                        selectedImage = image
                    }) {
                        Image(
                            bitmap = image.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier.size(ImageSize)
                        )
                    }

                    Spacer(modifier = Modifier.height(VerySmallPadding))

                    IconButton(onClick = {
                        images.removeAt(index)
                    }) {
                        Icon(
                            Icons.Default.Delete,
                            tint = Color.Red,
                            contentDescription = "Delete image"
                        )
                    }
                }
            }
        }
    }

    if (selectedImage != null) {
        ViewImage(
            bitmap = selectedImage!!,
            close = { selectedImage = null }
        )
    }

}

@Composable
fun ViewImage(
    bitmap: Bitmap,
    close: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            IconButton(
                onClick = close,
                modifier = Modifier
                    .padding(VerySmallPadding)
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.size(ImageSize)
            )
        }
    }
}