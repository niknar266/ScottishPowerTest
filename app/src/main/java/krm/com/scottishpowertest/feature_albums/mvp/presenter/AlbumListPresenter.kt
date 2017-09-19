package krm.com.scottishpowertest.feature_albums.mvp.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import krm.com.scottishpowertest.feature_albums.mvp.view.AlbumListView

class AlbumListPresenter : BaseListPresenter<> {

    fun fillList() {
        val albums = mAPIService.getAlbums()
        albums.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { albumList ->
                    view.setListAdapter(albumList)
                }
    }
}