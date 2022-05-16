package com.example.recipesdemo.ui.screens.edamamscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesdemo.data.models.responses.Hit
import com.example.recipesdemo.usecase.EdamamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EdamamViewModel @Inject constructor(
    private val edamamUseCases: EdamamUseCases
    ): ViewModel() {

    private val _info = mutableStateOf<List<Hit>?>(mutableListOf())
    val list: MutableState<List<Hit>?> = _info

    fun getRecipe(q: String) {
        viewModelScope.launch {
            list.value = edamamUseCases.getRecipe(q).hits
        }
    }
}