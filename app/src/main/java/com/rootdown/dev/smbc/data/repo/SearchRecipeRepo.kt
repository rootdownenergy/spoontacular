package com.rootdown.dev.smbc.data.repo

import com.rootdown.dev.smbc.data.model.remote.RemoteSourceComplexSearch
import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import com.rootdown.dev.smbc.lib.helpers.Resource

interface SearchRecipeRepo {
    suspend fun searchRecipes() : Resource<RemoteSourceSpoonacular>
    suspend fun searchComplex() : Resource<RemoteSourceComplexSearch>
}