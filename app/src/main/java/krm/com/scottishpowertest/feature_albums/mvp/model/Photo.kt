package krm.com.scottishpowertest.feature_albums.mvp.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(var albumId : Int = 0, @PrimaryKey var id : Int = 0, var title : String = "", var url : String = "", var thumbnailUrl : String = "")