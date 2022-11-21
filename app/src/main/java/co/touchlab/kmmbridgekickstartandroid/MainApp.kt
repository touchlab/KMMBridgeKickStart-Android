package co.touchlab.kmmbridgekickstartandroid

import android.app.Application
import co.touchlab.kmmbridgekickstart.startSDK
import co.touchlab.kmmbridgekickstartandroid.viewmodel.BreedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val sdkHandle = startSDK(analytics = AndroidAnalytics(), context = this)
        sdkHandle.appAnalytics.appStarted()

        startKoin {
            modules(
                module {
                    viewModel { BreedViewModel(breedRepository = sdkHandle.breedRepository, breedAnalytics = sdkHandle.breedAnalytics) }
                }
            )
        }
    }
}
