package krm.com.scottishpowertest.commons.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(context: Context) {
    var mContext: Context = context

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return mContext
    }
}