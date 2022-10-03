package co.touchlab.brownfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.touchlab.brownfield.ui.MainScreen
import co.touchlab.brownfield.ui.theme.BrownfieldTheme
import co.touchlab.brownfield.viewmodel.BreedViewModel
import co.touchlab.kermit.Logger
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    private val log: Logger by inject { parametersOf("MainActivity") }
    private val viewModel: BreedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrownfieldTheme {
                MainScreen(viewModel, log)
            }
        }
    }
}
