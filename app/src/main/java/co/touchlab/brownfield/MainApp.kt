package co.touchlab.brownfield

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import co.touchlab.brownfield.viewmodel.BreedViewModel
import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
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
                    val baseLogger = Logger(config = StaticConfig(logWriterList = listOf(platformLogWriter())), "KampKit")
                    factory { baseLogger }

                    single<Context> { this@MainApp }
                    viewModel { BreedViewModel(get()) }
                    single<SharedPreferences> {
                        get<Context>().getSharedPreferences("KAMPSTARTER_SETTINGS", Context.MODE_PRIVATE)
                    }
                    single {
                        { Log.i("Startup", "Hello from Android/Kotlin!") }
                    }
                }
            )
        }
    }
}
