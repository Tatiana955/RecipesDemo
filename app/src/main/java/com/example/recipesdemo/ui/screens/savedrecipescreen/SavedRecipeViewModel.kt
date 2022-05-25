package com.example.recipesdemo.ui.screens.savedrecipescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.recipesdemo.data.models.local.realms.RecipeRealm
import com.example.recipesdemo.usecase.EdamamUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.RealmResults
import javax.inject.Inject

@HiltViewModel
class SavedRecipeViewModel @Inject constructor(
    private val edamamUseCases: EdamamUseCases
    ): ViewModel() {

    private val _list = mutableStateOf<RealmResults<RecipeRealm>?>(null)
    val list: MutableState<RealmResults<RecipeRealm>?> = _list

    fun getRecipes() {
        list.value = edamamUseCases.getRecipes.invoke()
    }
}