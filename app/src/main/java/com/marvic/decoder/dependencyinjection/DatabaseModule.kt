package com.marvic.decoder.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.marvic.decoder.data.database.room.DecoderDatabase
import com.marvic.decoder.data.database.room.UserDao
import com.marvic.decoder.data.repository.UserDaoImpl
import com.marvic.decoder.viewModels.user.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DecoderDatabase {
        return Room.databaseBuilder(context, DecoderDatabase::class.java, "decoder_database")
            .build()
    }

    @Provides
    fun userDao(database: DecoderDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideUserViewModel(userDao: UserDaoImpl): UserViewModel {
        return UserViewModel(userDao)
    }

}