package com.example.mylegoconstriuktor

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [LegoParts::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun legoPartsDao(): LegoPartsDao
}