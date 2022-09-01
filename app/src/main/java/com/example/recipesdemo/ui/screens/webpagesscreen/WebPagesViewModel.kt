package com.example.recipesdemo.ui.screens.webpagesscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.recipesdemo.usecase.EdamamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WebPagesViewModel @Inject constructor(
    private val edamamUseCases: EdamamUseCases
): ViewModel() {

    private val _dataPrKey= mutableStateOf("")
    val dataPrKey: MutableState<String> = _dataPrKey

    private val _dataUrl= mutableStateOf("")
    val dataUrl: MutableState<String> = _dataUrl

    fun getSourceUrl() {
        dataUrl.value = edamamUseCases.getRecipeByPrimaryKey(dataPrKey.value)?.url!!
    }
}