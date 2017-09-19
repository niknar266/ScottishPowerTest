package krm.com.scottishpowertest.commons.network

import io.reactivex.Flowable
import krm.com.scottishpowertest.feature_albums.mvp.model.Album
import krm.com.scottishpowertest.feature_albums.mvp.model.Picture
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("albums")
    fun getAlbums() : Flowable<List<Album>>

    @GET("albums/{id}/photos")
    fun getAlbums(@Path("id") id : String) : Flowable<List<Picture>>
}
