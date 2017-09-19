package krm.com.scottishpowertest.feature_albums.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_album_list.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.MyApplication
import krm.com.scottishpowertest.commons.network.APIService
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.adapter.PictureAdapter
import krm.com.scottishpowertest.feature_albums.mvp.model.Picture
import krm.com.scottishpowertest.feature_albums.mvp.view.ImageGridListView
import javax.inject.Inject

class ImageGridListFragment : Fragment(), RecyclerViewClickListener, ImageGridListView {
    override fun setListAdapter(photoList: List<Picture>) {
        val pictureAdapter = PictureAdapter(context, photoList, this)
        recyclerview_album_list.layoutManager = GridLayoutManager(context, COLUMN_COUNT)
        recyclerview_album_list.adapter = pictureAdapter
    }

    override fun refreshView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadImageDetail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(view: View, position: Int) {
        Toast.makeText(activity, "I am view " + position,Toast.LENGTH_SHORT).show()
    }

    val COLUMN_COUNT : Int = 2

    @Inject
    lateinit var mAPIService: APIService

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        MyApplication.appComponent.inject(this)

        val view = inflater!!.inflate(R.layout.fragment_album_list, container, false)

        val albums = mAPIService.getAlbums("1")
        albums.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { photoList ->
                }
        return view
    }
}
