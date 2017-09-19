package krm.com.scottishpowertest.feature_albums.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_photo_list_item.view.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.mvp.model.Picture
import krm.com.scottishpowertest.feature_albums.viewholder.PictureViewHolder

class PictureAdapter(private val context : Context, private val mPhotoList: List<Picture>, private val mListener : RecyclerViewClickListener) : RecyclerView.Adapter<PictureViewHolder>() {
    init {
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_list_item, null)
        return PictureViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val photo : Picture = mPhotoList[position]

        Picasso.with(context).load(photo.thumbnailUrl).into(holder.itemView.imageview_photo)
    }

    override fun getItemCount(): Int {
        return mPhotoList.size
    }

}