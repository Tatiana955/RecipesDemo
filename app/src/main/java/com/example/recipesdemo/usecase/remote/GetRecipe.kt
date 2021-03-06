package com.example.recipesdemo.usecase.remote

import com.example.recipesdemo.util.Resource
import com.example.recipesdemo.data.models.EdamamRepository
import com.example.recipesdemo.data.models.remote.responses.Edamam
import com.example.recipesdemo.data.models.MissingDataException
import javax.inject.Inject
import kotlin.jvm.Throws

class GetRecipe @Inject constructor(
    private val repository: EdamamRepository
) {
    @Throws(MissingDataException::class)
    suspend operator fun invoke(q: String): Edamam {
        return when (val data = repository.getRecipe(q)) {
            is Resource.Success -> {
                data.data!!
            }
            else -> {
                throw MissingDataException("No data.")
            }
        }
    }
}
