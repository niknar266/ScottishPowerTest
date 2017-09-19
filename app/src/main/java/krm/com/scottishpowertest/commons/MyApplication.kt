package krm.com.scottishpowertest.commons

import android.app.Application
import krm.com.scottishpowertest.commons.di.components.AppComponent
import krm.com.scottishpowertest.commons.di.components.DaggerAppComponent
import krm.com.scottishpowertest.commons.di.module.AppModule
import krm.com.scottishpowertest.commons.di.module.ContextModule
import krm.com.scottishpowertest.commons.di.module.DatabaseModule
import krm.com.scottishpowertest.commons.di.module.NetworkModule

class MyApplication : Application() {

    val API_URL : String = "https://jsonplaceholder.typicode.com/"

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .databaseModule(DatabaseModule())
                .contextModule(ContextModule(this))
                .networkModule(NetworkModule(API_URL))
                .build()
    }
}

