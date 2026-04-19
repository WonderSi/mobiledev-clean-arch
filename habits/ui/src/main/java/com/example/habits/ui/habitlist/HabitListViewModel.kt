package com.example.habits.ui.habitlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habits.domain.usecase.GetAllHabitsUseCase
import com.example.habits.domain.usecase.ToggleHabitCompletionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HabitListViewModel @Inject constructor(
    private val getAllHabitsUseCase: GetAllHabitsUseCase,
    private val toggleHabitCompletionUseCase: ToggleHabitCompletionUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HabitListUiState(isLoading = true))
    val uiState: StateFlow<HabitListUiState> = _uiState.asStateFlow()

    init {
        loadHabits()
    }

    private fun loadHabits() {
        viewModelScope.launch {
            getAllHabitsUseCase().collect { habits ->
                _uiState.update { it.copy(habits = habits, isLoading = false) }
            }
        }
    }

    fun toggleCompletion(habitId: Long, date: LocalDate = LocalDate.now()) {
        viewModelScope.launch {
            try {
                toggleHabitCompletionUseCase(habitId, date)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message) }
            }
        }
    }
}
