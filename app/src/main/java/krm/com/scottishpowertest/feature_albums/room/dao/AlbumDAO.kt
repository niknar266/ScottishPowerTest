package krm.com.scottishpowertest.feature_albums.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import krm.com.scottishpowertest.feature_albums.mvp.model.Album

@Dao
interface AlbumDAO {
    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Flowable<List<Album>>

    @Insert
    fun insertAll(albums: List<Album>)

    @Query("DELETE FROM albums")
    fun delete()
}