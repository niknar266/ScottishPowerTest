package krm.com.scottishpowertest.feature_albums.mvp.view

import krm.com.scottishpowertest.feature_albums.mvp.model.Picture

interface ImageGridListView : BaseListView {
    fun loadImageDetail()

    fun setListAdapter(photoList: List<Picture>)
}