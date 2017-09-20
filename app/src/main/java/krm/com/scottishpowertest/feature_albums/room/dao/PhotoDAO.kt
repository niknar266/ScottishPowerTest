package krm.com.scottishpowertest.feature_albums.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import krm.com.scottishpowertest.feature_albums.mvp.model.Photo

@Dao
interface PhotoDAO {
    @Query("SELECT * FROM photos")
    fun getAllPhotos(): Flowable<List<Photo>>

    @Insert
    fun insertAll(albums: List<Photo>)

    @Query("DELETE FROM photos")
    fun delete()
}
