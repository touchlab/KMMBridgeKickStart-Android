package co.touchlab.kmmbridgekickstartandroid

import android.app.Application
import android.content.Context
import co.touchlab.kmmbridgekickstartandroid.viewmodel.BreedViewModel
import co.touchlab.kmmbridgekickstart.AndroidServiceLocator
import co.touchlab.kmmbridgekickstart.AppAnalytics
import co.touchlab.kmmbridgekickstart.initAnalytics
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
