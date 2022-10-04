package co.touchlab.brownfield

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import co.touchlab.brownfield.viewmodel.BreedViewModel
import co.touchlab.brownfieldsdk.coreModule
import co.touchlab.brownfieldsdk.platformModule
import co.touchlab.brownfieldsdk.repository.BreedRepository
import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    // platformLogWriter() is a relatively simple config option, useful for local debugging. For production
                    // uses you *may* want to have a more robust configuration from the native platform. In KaMP Kit,
                    // that would likely go into platformModule expect/actual.
                    // See https://github.com/touchlab/Kermit
//                    val baseLogger = Logger(config = StaticConfig(logWriterList = listOf(platformLogWriter())), "Brownfield")
//                    factory { baseLogger }

//                    single<SharedPreferences> {
//                        get<Context>().getSharedPreferences("BROWNFIELD_SETTINGS", Context.MODE_PRIVATE)
//                    }

                    single<Context> { this@MainApp }
                    viewModel { BreedViewModel(breedRepository = get()) }
                },
                platformModule,
                coreModule,
            )
        }
    }
}
