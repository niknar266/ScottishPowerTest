package krm.com.scottishpowertest.commons.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import krm.com.scottishpowertest.commons.network.APIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton




@Module
class NetworkModule(private val baseURL : String) {
    @Provides
    @Singleton
    @Inject
    fun provideRetrofit(): APIService {
        val client = OkHttpClient.Builder().build()

        val retroFit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseURL)
                .client(client)
                .build()

        return retroFit.create(APIService::class.java)
    }
}