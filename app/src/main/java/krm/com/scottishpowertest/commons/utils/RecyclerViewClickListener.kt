package krm.com.scottishpowertest.commons.utils

import android.view.View

interface RecyclerViewClickListener {
    fun onClick(view: View, position: Int)
}