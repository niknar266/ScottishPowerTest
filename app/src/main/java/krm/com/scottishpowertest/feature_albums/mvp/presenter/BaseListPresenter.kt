package krm.com.scottishpowertest.feature_albums.mvp.presenter

import krm.com.scottishpowertest.commons.mvp.BasePresenter
import krm.com.scottishpowertest.commons.network.APIService
import krm.com.scottishpowertest.feature_albums.mvp.view.BaseListView
import javax.inject.Inject

open class BaseListPresenter : BasePresenter<BaseListView>() {

    @Inject
    lateinit var mAPIService : APIService
}