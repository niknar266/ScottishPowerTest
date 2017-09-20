package krm.com.scottishpowertest.feature_albums.mvp.presenter

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import krm.com.scottishpowertest.commons.MyApplication
import krm.com.scottishpowertest.feature_albums.mvp.model.Album
import krm.com.scottishpowertest.feature_albums.mvp.view.AlbumListView

class AlbumListPresenter : BaseListPresenter<AlbumListView>() {
    init {
        MyApplication.appComponent.inject(this)
    }

    override fun onViewCreated(view: AlbumListView) {
        super.onViewCreated(view)
    }

    fun fillListFromRESTService() {
        view?.showProgress()
        deleteListFromDB()

        Log.i("loading", "Loading albums from REST Service")

        val albums = mAPIService.getAlbums()

        mCompositeDisposable.add(albums.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { albumList ->
                    val sortList = albumList.sortedWith(compareBy({it.title}))

                    view?.hideProgress()
                    saveListToDB(sortList)
                    view?.setListAdapter(albumList)
                })
    }

    fun fillListFromDB() {
        Log.i("loading", "Loading albums from DB")

        mDatabase.albumDAO().getAllAlbums()
                .subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe{ albumList ->
                    val sortList = albumList.sortedWith(compareBy({it.title}))

                    view?.hideProgress()
                    view?.setListAdapter(sortList)
                }
    }

    fun saveListToDB(albums: List<Album>) {
        mCompositeDisposable.add(Observable.fromCallable{ mDatabase.albumDAO().insertAll(albums)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }

    fun deleteListFromDB() {
        mCompositeDisposable.add(Observable.fromCallable{ mDatabase.albumDAO().delete()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}