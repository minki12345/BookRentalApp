package com.example.bookrentalapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [RentalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // RentalDao 연결
    abstract fun rentalDao(): RentalDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        // 앱 전체에서 같은 DB 인스턴스 사용
        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "book_rental_database"
                ).build().also { instance = it }
            }
        }
    }
}