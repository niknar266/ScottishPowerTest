package krm.com.scottishpowertest.commons.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import krm.com.scottishpowertest.commons.room.AppDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(context: Context) : AppDatabase {
        return AppDatabase.getAppDatabase (context)
    }
}