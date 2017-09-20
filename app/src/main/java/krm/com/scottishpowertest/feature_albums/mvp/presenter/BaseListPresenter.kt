package krm.com.scottishpowertest.feature_albums.mvp.presenter

import krm.com.scottishpowertest.commons.mvp.BasePresenter
import krm.com.scottishpowertest.commons.network.APIService
import krm.com.scottishpowertest.commons.room.AppDatabase
import krm.com.scottishpowertest.feature_albums.mvp.view.BaseListView
import javax.inject.Inject

open class BaseListPresenter<T : BaseListView> : BasePresenter<T>() {
    @Inject
    lateinit var mAPIService : APIService

    @Inject
    lateinit var mDatabase : AppDatabase
}