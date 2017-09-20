package krm.com.scottishpowertest.feature_albums.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import krm.com.scottishpowertest.commons.utils.RecyclerViewClickListener

class AlbumViewHolder(itemView: View, private val mListener : RecyclerViewClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        mListener.onClick(itemView, adapterPosition)
    }
}
