package krm.com.scottishpowertest.commons.di.module
import dagger.Module
import dagger.Provides
import krm.com.scottishpowertest.commons.MyApplication
import javax.inject.Singleton

@Module
class AppModule(private val app: MyApplication) {

    @Provides
    @Singleton
    fun provideApplication() = app
}
