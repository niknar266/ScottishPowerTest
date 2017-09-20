package krm.com.scottishpowertest.feature_albums.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image_detail.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.feature_albums.activity.MainActivity
import krm.com.scottishpowertest.feature_albums.mvp.presenter.ImageDetailPresenter
import krm.com.scottishpowertest.feature_albums.mvp.view.ImageDetailView


class ImageDetailFragment : Fragment(), ImageDetailView {

    val mPresenter : ImageDetailPresenter = ImageDetailPresenter()
    private var mTitle: String? = null
    private var mImageURL: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            mTitle = arguments?.getString(ARG_TITLE)
            mImageURL = arguments?.getString(ARG_URL)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mPresenter.onViewCreated(this)

        return inflater!!.inflate(R.layout.fragment_image_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        Picasso.with(context).load(mImageURL).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(R.drawable.ic_image_24dp).into(imageview_full_image)
        textview_image_title.text = mTitle
    }

    override fun onDestroyView() {
        mPresenter.onViewDestroyed()
        Picasso.with(context).cancelRequest(imageview_full_image)
        super.onDestroyView()
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_TITLE = "title"
        private val ARG_URL = "image_url"

        fun newInstance(title: String, imageURL: String): ImageDetailFragment {
            val fragment = ImageDetailFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_URL, imageURL)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
