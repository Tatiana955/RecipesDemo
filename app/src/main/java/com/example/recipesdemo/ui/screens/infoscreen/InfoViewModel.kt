package com.example.recipesdemo.ui.screens.infoscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesdemo.data.models.responses.Recipe
import com.example.recipesdemo.usecase.EdamamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val edamamUseCases: EdamamUseCases
    ): ViewModel() {

    private val _dataId= mutableStateOf("")
    val dataId: MutableState<String> = _dataId

    private val _info = mutableStateOf<Recipe?>(null)
    val info: MutableState<Recipe?> = _info

    init {
        getInfoById()
    }

    private fun getInfoById() {
        viewModelScope.launch {
            delay(1000)
            info.value = edamamUseCases.getRecipeById(dataId.value).recipe
        }
    }
}