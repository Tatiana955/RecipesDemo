package com.example.recipesdemo.usecase.remote

import com.example.recipesdemo.data.models.EdamamRepository
import com.example.recipesdemo.data.models.MissingDataException
import com.example.recipesdemo.data.models.remote.responses.Hit
import com.example.recipesdemo.util.Resource
import javax.inject.Inject

class GetRecipeById @Inject constructor(
    private val repository: EdamamRepository
) {
    @Throws(MissingDataException::class)
    suspend operator fun invoke(id: String): Hit {
        return when (val data = repository.getRecipeById(id)) {
            is Resource.Success -> {
                data.data!!
            }
            else -> {
                throw MissingDataException("No data.")
            }
        }
    }
}