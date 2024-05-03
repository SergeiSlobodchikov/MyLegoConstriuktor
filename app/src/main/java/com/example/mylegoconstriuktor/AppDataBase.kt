package com.example.mylegoconstriuktor

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assembletheconstructoryourself.LegoParts
import com.example.assembletheconstructoryourself.LegoPartsDao

@Database(entities = [LegoParts::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun legoPartsDao(): LegoPartsDao
}