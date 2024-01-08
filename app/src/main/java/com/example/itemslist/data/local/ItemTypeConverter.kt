package com.example.itemslist.data.local

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.nio.ByteBuffer

@ProvidedTypeConverter
class ItemTypeConverter {
    @TypeConverter
    fun bitmapsToBase64List(bitmaps: List<Bitmap>): String {
        val base64List = mutableListOf<String>()

        for (bitmap in bitmaps) {
            val byteBuffer = ByteBuffer.allocate(bitmap.height * bitmap.rowBytes)
            bitmap.copyPixelsToBuffer(byteBuffer)
            val byteArray = byteBuffer.array()
            val base64String = Base64.encodeToString(byteArray, Base64.DEFAULT)
            base64List.add(base64String)
        }

        return base64List.joinToString(separator = ",")
    }

    @TypeConverter
    fun base64ListToBitmaps(base64ListString: String): List<Bitmap> {
        val base64List = base64ListString.split(",").toTypedArray()

        return base64List.map { base64String ->
            val byteArray = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        }
    }
}