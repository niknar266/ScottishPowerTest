package krm.com.scottishpowertest.commons.di.components

import dagger.Component
import krm.com.scottishpowertest.commons.di.module.AppModule
import krm.com.scottishpowertest.commons.di.module.ContextModule
import krm.com.scottishpowertest.commons.di.module.DatabaseModule
import krm.com.scottishpowertest.feature_albums.activity.MainActivity
import krm.com.scottishpowertest.feature_albums.mvp.presenter.MainPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(
    AppModule::class,
    ContextModule::class,
    DatabaseModule::class)
)
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}
