package com.example.itemslist.di

import android.app.Application
import androidx.room.Room
import com.example.itemslist.data.local.ItemDao
import com.example.itemslist.data.local.ItemDb
import com.example.itemslist.data.local.ItemTypeConverter
import com.example.itemslist.data.repository.ItemRepositoryImpl
import com.example.itemslist.domain.repository.ItemRepository
import com.example.itemslist.util.Constants.ITEM_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideItemDb(
        application: Application
    ) = Room.databaseBuilder(
        context = application,
        klass = ItemDb::class.java,
        name = ITEM_DATABASE_NAME
    )
        .addTypeConverter(ItemTypeConverter())
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideItemDao(
        itemDb: ItemDb
    ) = itemDb.itemDao

    @Provides
    @Singleton
    fun provideItemRepository(
        itemDao: ItemDao
    ): ItemRepository = ItemRepositoryImpl(
        itemDao = itemDao
    )

}