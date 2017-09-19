package krm.com.scottishpowertest.feature_albums.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_album_list.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.MyApplication
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.adapter.AlbumAdapter
import krm.com.scottishpowertest.feature_albums.mvp.model.Album
import krm.com.scottishpowertest.feature_albums.mvp.view.AlbumListView

class AlbumListFragment : Fragment(), AlbumListView, RecyclerViewClickListener {

    override fun setListAdapter(albumList : List<Album>) {
        val albumAdapter = AlbumAdapter(albumList, this)
        recyclerview_album_list.layoutManager = GridLayoutManager(context, 1)
        recyclerview_album_list.adapter = albumAdapter
    }

    override fun loadImageGridView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(view: View, position: Int) {
        loadImageGridView()
    }

    override fun refreshView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        MyApplication.appComponent.inject(this)
        val view = inflater!!.inflate(R.layout.fragment_album_list, container, false)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}