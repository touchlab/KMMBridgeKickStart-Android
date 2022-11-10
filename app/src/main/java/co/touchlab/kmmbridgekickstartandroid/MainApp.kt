package co.touchlab.kmmbridgekickstartandroid

import android.app.Application
import android.content.Context
import co.touchlab.kmmbridgekickstart.AppAnalytics
import co.touchlab.kmmbridgekickstart.breedStartup
import co.touchlab.kmmbridgekickstart.initAnalytics
import co.touchlab.kmmbridgekickstartandroid.viewmodel.BreedViewModel
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
                    single { breedStartup(context = get()) }
                    viewModel { BreedViewModel(breedRepository = get()) }
                }
            )
        }
    }
}
