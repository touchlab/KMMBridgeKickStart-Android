package co.touchlab.kmmbridgekickstartandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import co.touchlab.kmmbridgekickstart.BreedAnalytics
import co.touchlab.kmmbridgekickstartandroid.ui.MainScreen
import co.touchlab.kmmbridgekickstartandroid.ui.theme.KMMBridgeKickStartAndroidTheme
import co.touchlab.kmmbridgekickstartandroid.viewmodel.BreedViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: BreedViewModel by viewModel()
    private val breedAnalytics: BreedAnalytics = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMMBridgeKickStartAndroidTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen(viewModel, breedAnalytics)
                }
            }
        }
    }
}
