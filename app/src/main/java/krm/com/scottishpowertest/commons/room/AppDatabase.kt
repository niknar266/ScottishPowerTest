package krm.com.scottishpowertest.commons.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import krm.com.scottishpowertest.feature_albums.mvp.model.Album
import krm.com.scottishpowertest.feature_albums.mvp.model.Photo
import krm.com.scottishpowertest.feature_albums.room.dao.AlbumDAO
import krm.com.scottishpowertest.feature_albums.room.dao.PhotoDAO

@Database(entities = arrayOf(Album::class, Photo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private const val DB_NAME = "albums-database.db"

        fun getAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
    }

    abstract fun albumDAO(): AlbumDAO

    abstract fun photoDAO(): PhotoDAO
}
