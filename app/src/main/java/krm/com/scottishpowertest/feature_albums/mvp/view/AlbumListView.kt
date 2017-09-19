package krm.com.scottishpowertest.feature_albums.mvp.view

import krm.com.scottishpowertest.feature_albums.mvp.model.Album

interface AlbumListView : BaseListView {
    fun loadImageGridView()

    fun setListAdapter(albumList: List<Album>)

}