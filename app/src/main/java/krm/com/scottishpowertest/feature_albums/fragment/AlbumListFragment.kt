package krm.com.scottishpowertest.feature_albums.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_album_list.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.activity.MainActivity
import krm.com.scottishpowertest.feature_albums.adapter.AlbumAdapter
import krm.com.scottishpowertest.feature_albums.mvp.model.Album
import krm.com.scottishpowertest.feature_albums.mvp.presenter.AlbumListPresenter
import krm.com.scottishpowertest.feature_albums.mvp.view.AlbumListView

class AlbumListFragment : Fragment(), AlbumListView, RecyclerViewClickListener {
    val mPresenter : AlbumListPresenter = AlbumListPresenter()
    var mIsRestoredFromBackstack : Boolean = false

    override fun showProgress() {
        progress_bar_album_list.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar_album_list.visibility = View.GONE
    }

    override fun setListAdapter(albumList : List<Album>) {
        swiperefresh_albums.isRefreshing = false

        val albumAdapter = AlbumAdapter(albumList, this)
        recyclerview_album_list.layoutManager = GridLayoutManager(context, 1)
        recyclerview_album_list.adapter = albumAdapter
    }

    override fun loadImageGridView(albumId : String) {
        val fragment = ImageGridListFragment.newInstance(albumId)
        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(ImageGridListFragment::class.java.name)
        fragmentTransaction.commit()
    }

    override fun onClick(view: View, position: Int) {
        val adapter : AlbumAdapter = recyclerview_album_list.adapter as AlbumAdapter
        val album : Album = adapter.getItemAt(position)

        loadImageGridView(album.id.toString())
    }

    override fun refreshView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_album_list, container, false)

        ButterKnife.bind(view)
        mPresenter.onViewCreated(this)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return view
    }

    override fun onStart() {
        super.onStart()
        swiperefresh_albums.setOnRefreshListener {  mPresenter.fillListFromRESTService() }
    }

    override fun onResume() {
        super.onResume()
        if(mIsRestoredFromBackstack) {
            mPresenter.fillListFromDB()
        } else {
            mPresenter.fillListFromRESTService()
        }
    }

    override fun onDestroyView() {
        mPresenter.onViewDestroyed()
        mIsRestoredFromBackstack = true
        super.onDestroyView()
    }

    @OnClick(R.id.fab_add_album)
    fun onFabClicked() {
        Toast.makeText(context, "I'm part of a new feature", Toast.LENGTH_SHORT).show()
    }

}