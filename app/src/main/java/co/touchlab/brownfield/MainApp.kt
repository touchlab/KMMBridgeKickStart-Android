package co.touchlab.brownfield

import android.app.Application
import android.content.Context
import co.touchlab.brownfield.viewmodel.BreedViewModel
import co.touchlab.brownfieldsdk.Analytics
import co.touchlab.brownfieldsdk.AndroidServiceLocator
import co.touchlab.brownfieldsdk.AppAnalytics
import co.touchlab.brownfieldsdk.BreedAnalytics
import co.touchlab.brownfieldsdk.HttpClientAnalytics
import co.touchlab.brownfieldsdk.initAnalytics
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val koinApp = startKoin {
            modules(
                module {
                    single { initAnalytics(AndroidAnalytics()) }

                    single<Context> { this@MainApp }

                    single {
                        AndroidServiceLocator(
                            context = get(),
                            analytics = get()
                        )
                    }

                    single { get<AndroidServiceLocator>().breedRepository }

                    single { get<AndroidServiceLocator>().appAnalytics }

                    single { get<AndroidServiceLocator>().breedAnalytics }

                    single { get<AndroidServiceLocator>().httpClientAnalytics }

                    viewModel {
                        BreedViewModel(
                            breedRepository = get(),
                            breedAnalytics = get()
                        )
                    }
                },
            )
        }

        koinApp.koin.get<AppAnalytics>().appStarted()
    }
}
