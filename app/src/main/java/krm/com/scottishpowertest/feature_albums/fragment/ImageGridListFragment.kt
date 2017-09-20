package krm.com.scottishpowertest.feature_albums.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image_grid_list.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.activity.MainActivity
import krm.com.scottishpowertest.feature_albums.adapter.PhotoAdapter
import krm.com.scottishpowertest.feature_albums.mvp.model.Photo
import krm.com.scottishpowertest.feature_albums.mvp.presenter.ImageGridListPresenter
import krm.com.scottishpowertest.feature_albums.mvp.view.ImageGridListView

class ImageGridListFragment : Fragment(), RecyclerViewClickListener, ImageGridListView {

    var mIsRestoredFromBackstack : Boolean = false
    val mPresenter : ImageGridListPresenter = ImageGridListPresenter()

    override fun showProgress() {
        progress_bar_photo_grid.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar_photo_grid.visibility = View.GONE
    }

    override fun setListAdapter(photoList: List<Photo>) {
        swiperefresh_photos.isRefreshing = false

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pictureAdapter = PhotoAdapter(context, photoList, this)
        recyclerview_photo_list.layoutManager = GridLayoutManager(context, COLUMN_COUNT)
        recyclerview_photo_list.adapter = pictureAdapter
    }

    override fun refreshView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadImageDetail(title : String, url : String) {
        val fragment = ImageDetailFragment.newInstance(title, url)
        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(ImageDetailFragment::class.java.name)
        fragmentTransaction.commit()
    }

    override fun onClick(view: View, position: Int) {
        val photo : Photo = (recyclerview_photo_list.adapter as PhotoAdapter).getItemAt(position)
        loadImageDetail(photo.title, photo.url)
    }

    val COLUMN_COUNT : Int = 2

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mPresenter.onViewCreated(this)
        mIsRestoredFromBackstack = false
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return inflater!!.inflate(R.layout.fragment_image_grid_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        swiperefresh_photos.setOnRefreshListener {  mPresenter.fillListFromRestService(arguments.getString(ARG_ALBUM_ID)) }
    }

    override fun onResume() {
        super.onResume()
        if(mIsRestoredFromBackstack) {
            mPresenter.fillListFromDB()
        } else {
            mPresenter.fillListFromRestService(arguments.getString(ARG_ALBUM_ID))
        }
    }

    override fun onDestroyView() {
        mIsRestoredFromBackstack = true
        super.onDestroyView()
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_ALBUM_ID = "id"

        fun newInstance(id: String): ImageGridListFragment {
            val fragment = ImageGridListFragment()
            val args = Bundle()
            args.putString(ARG_ALBUM_ID, id)
            fragment.arguments = args
            return fragment
        }
    }
}
