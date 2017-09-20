package krm.com.scottishpowertest.feature_albums.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_album_list_item.view.*
import krm.com.scottishpowertest.R
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener
import krm.com.scottishpowertest.feature_albums.mvp.model.Album
import krm.com.scottishpowertest.feature_albums.viewholder.AlbumViewHolder



class AlbumAdapter(private val mAlbumList: List<Album>, private val mListener: RecyclerViewClickListener) : RecyclerView.Adapter<AlbumViewHolder>() {
    init {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_album_list_item, null)
        return AlbumViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album : Album = mAlbumList[position]
        holder.itemView.textview_name.text = album.title
    }

    override fun getItemCount(): Int {
        return mAlbumList.size
    }

    fun getItemAt(position: Int) : Album {
        return mAlbumList[position]
    }
}
