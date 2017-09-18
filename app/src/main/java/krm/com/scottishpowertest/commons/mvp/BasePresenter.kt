package krm.com.scottishpowertest.commons.mvp

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

open class BasePresenter<T : BaseView> {

    private var mViewRef: WeakReference<T>? = null
    protected var mCompositeDisposable = CompositeDisposable()

    @CallSuper
    open fun onViewCreated(view: T) {
        mViewRef = WeakReference(view)
    }

    @CallSuper
    fun onViewDestroyed() {
        mViewRef!!.clear()
        mCompositeDisposable.dispose()
    }

    val view: T?
        get() {
            if (mViewRef == null || mViewRef?.get() == null) {
                throw ViewNotAttachedException()
            } else {
                return mViewRef?.get()
            }
        }

    private class ViewNotAttachedException internal constructor() : IllegalStateException("Trying to access a view that is not attached")
}

