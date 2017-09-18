package krm.com.scottishpowertest.commons.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(private var context: Context) {
    var mContext: Context

    init {
        mContext = context
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return mContext
    }
}