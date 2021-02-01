package com.example.instagroy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.instagroy.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                 "user_table"
            ).build()
            return INSTANCE!!
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }





}