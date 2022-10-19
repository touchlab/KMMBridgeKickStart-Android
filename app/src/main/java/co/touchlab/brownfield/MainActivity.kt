package co.touchlab.brownfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import co.touchlab.brownfield.ui.MainScreen
import co.touchlab.brownfield.ui.theme.BrownfieldTheme
import co.touchlab.brownfield.viewmodel.BreedViewModel
import co.touchlab.brownfieldsdk.BreedAnalytics
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: BreedViewModel by viewModel()
    private val breedAnalytics: BreedAnalytics by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrownfieldTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen(viewModel, breedAnalytics)
                }
            }
        }
    }
}
