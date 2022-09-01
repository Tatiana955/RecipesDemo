package com.example.recipesdemo.ui.screens.detailsrecipescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import com.example.recipesdemo.usecase.EdamamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsRecipeViewModel @Inject constructor(
    private val edamamUseCases: EdamamUseCases
): ViewModel() {

    private val _dataPrimaryKey= mutableStateOf("")
    val dataPrimaryKey: MutableState<String> = _dataPrimaryKey

    private val _recipe = mutableStateOf<RecipeRealm?>(null)
    val recipe: MutableState<RecipeRealm?> = _recipe

    fun getRecipeByPrimaryKey() {
        recipe.value = edamamUseCases.getRecipeByPrimaryKey(dataPrimaryKey.value)
    }
}