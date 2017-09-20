package krm.com.scottishpowertest.feature_albums.mvp.presenter

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import krm.com.scottishpowertest.commons.MyApplication
import krm.com.scottishpowertest.feature_albums.mvp.model.Photo
import krm.com.scottishpowertest.feature_albums.mvp.view.ImageGridListView

class ImageGridListPresenter : BaseListPresenter<ImageGridListView>() {
    init {
        MyApplication.appComponent.inject(this)
    }

    fun fillListFromRestService(albumId: String) {
        view?.showProgress()
        deleteListFromDB()

        Log.i("loading", "Loading from REST Service")

        val photos = mAPIService.getPhotos(albumId)
        mCompositeDisposable.add(photos.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { photoList ->
                    val sortList = photoList.sortedWith(compareBy({it.url}))

                    view?.hideProgress()
                    saveListToDB(photoList)
                    view?.setListAdapter(sortList)
                })
    }

    fun fillListFromDB() {
        Log.i("loading", "Loading from DB")

        mDatabase.photoDAO().getAllPhotos()
                .subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe{ photoList ->
                    val sortList = photoList.sortedWith(compareBy({it.url}))

                    view?.hideProgress()
                    view?.setListAdapter(sortList)
                }

    }

    fun saveListToDB(photos:List<Photo>) {
        mCompositeDisposable.add(Observable.fromCallable{ mDatabase.photoDAO().insertAll(photos)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }

    fun deleteListFromDB() {
        mCompositeDisposable.add(Observable.fromCallable{ mDatabase.photoDAO().delete()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}