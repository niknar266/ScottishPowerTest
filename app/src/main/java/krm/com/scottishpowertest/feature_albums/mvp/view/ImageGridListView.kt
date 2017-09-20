package krm.com.scottishpowertest.feature_albums.mvp.view

import krm.com.scottishpowertest.feature_albums.mvp.model.Photo

interface ImageGridListView : BaseListView {
    fun loadImageDetail(title : String, url : String)

    fun setListAdapter(photoList: List<Photo>)
}