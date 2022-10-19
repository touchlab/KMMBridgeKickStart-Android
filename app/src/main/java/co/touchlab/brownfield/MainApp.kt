package co.touchlab.brownfield

import android.app.Application
import android.content.Context
import co.touchlab.brownfield.viewmodel.BreedViewModel
import co.touchlab.brownfieldsdk.AndroidServiceLocator
import co.touchlab.brownfieldsdk.AppAnalytics
import co.touchlab.brownfieldsdk.initAnalytics
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        
        initAnalytics(AndroidAnalytics())
        AppAnalytics.appStarted()

        startKoin {
            modules(
                module {
                    single<Context> { this@MainApp }
                    single { AndroidServiceLocator(context = get()).breedRepository }
                    viewModel { BreedViewModel(breedRepository = get()) }
                },
            )
        }
    }
}
