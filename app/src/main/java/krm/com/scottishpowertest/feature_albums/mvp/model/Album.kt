package krm.com.scottishpowertest.feature_albums.mvp.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "albums")
data class Album(@PrimaryKey var id : Int = 0, var title: String = "")
