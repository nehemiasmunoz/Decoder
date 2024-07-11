package com.marvic.decoder.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marvic.decoder.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DecoderDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: DecoderDatabase? = null

        fun getDatabase(context: Context): DecoderDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DecoderDatabase::class.java,
                    "decoder_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}