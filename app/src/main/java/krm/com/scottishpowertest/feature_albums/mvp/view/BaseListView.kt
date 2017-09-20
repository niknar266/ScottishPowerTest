package krm.com.scottishpowertest.feature_albums.mvp.view

interface BaseListView : MainView {
    fun refreshView()

    fun showProgress()

    fun hideProgress()
}