package co.touchlab.brownfield.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BreedViewModel(
    log: Logger
) : ViewModel() {
    private val log = log.withTag("BreedCommonViewModel")

    private val mutableBreedState: MutableStateFlow<BreedViewState> =
        MutableStateFlow(BreedViewState(isLoading = true))

    val breedState: StateFlow<BreedViewState> = mutableBreedState

    private val breeds = mutableListOf(
        Breed(0, "Cute dog", true),
        Breed(1, "Little dog", false),
        Breed(2, "Small dog", false),
        Breed(3, "Big dog", false),
        Breed(4, "Epic dog", true)
    )

    init {
        observeBreeds()
    }

    override fun onCleared() {
        log.v("Clearing BreedViewModel")
    }

    private fun observeBreeds() {
        mutableBreedState.update { previousState ->
            BreedViewState(
                isLoading = false,
                breeds = breeds,
                error = null,
                isEmpty = false
            )
        }
    }

    fun refreshBreeds(): Job {
        // Set loading state, which will be cleared when the repository re-emits
        mutableBreedState.update { it.copy(isLoading = true) }
        return viewModelScope.launch {
            log.v { "refreshBreeds" }
            try {
                delay(1000)
                mutableBreedState.update { it.copy(isLoading = false) }
            } catch (exception: Exception) {
                handleBreedError(exception)
            }
        }
    }

    fun updateBreedFavorite(breed: Breed): Job {
        return viewModelScope.launch {
            // TODO
        }
    }

    private fun handleBreedError(throwable: Throwable) {
        log.e(throwable) { "Error downloading breed list" }
        mutableBreedState.update {
            if (it.breeds.isNullOrEmpty()) {
                BreedViewState(error = "Unable to refresh breed list")
            } else {
                // Just let it fail silently if we have a cache
                it.copy(isLoading = false)
            }
        }
    }
}

data class BreedViewState(
    val breeds: List<Breed>? = null,
    val error: String? = null,
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false
)

data class Breed(val id: Int, val name: String, var favorite: Boolean)
