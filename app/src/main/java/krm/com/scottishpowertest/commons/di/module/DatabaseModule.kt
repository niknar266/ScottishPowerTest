package krm.com.scottishpowertest.commons.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import krm.com.scottishpowertest.commons.room.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    @Inject
    fun providesAppDatabase(context: Context) : AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }
}