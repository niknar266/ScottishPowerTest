package krm.com.scottishpowertest.feature_albums.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_photo_list_item.view.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.mvp.model.Photo
import krm.com.scottishpowertest.feature_albums.viewholder.PhotoViewHolder

class PhotoAdapter(private val context : Context, private val mPhotoList: List<Photo>, private val mListener : RecyclerViewClickListener) : RecyclerView.Adapter<PhotoViewHolder>() {
    init {
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_photo_list_item, null)
        return PhotoViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo : Photo = mPhotoList[position]

        Picasso.with(context).load(photo.thumbnailUrl).into(holder.itemView.imageview_photo)
    }

    override fun getItemCount(): Int {
        return mPhotoList.size
    }

    fun getItemAt(position: Int) : Photo {
        return mPhotoList[position]
    }
}