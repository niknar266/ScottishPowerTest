package krm.com.scottishpowertest.commons.room

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "album-database").build()
            }
            return INSTANCE!!
        }
    }
}
