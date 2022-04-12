package com.rootdown.dev.smbc.ui.feature_recipe_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import com.rootdown.dev.smbc.lib.helpers.Event
import com.rootdown.dev.smbc.data.repo.SearchRecipeRepoImpl
import com.rootdown.dev.smbc.lib.helpers.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repo: SearchRecipeRepoImpl
) : ViewModel(){
    var count = 0
    var predaciteNum: Int = 0

    private val _recipeResult = MutableLiveData<Event<Resource<RemoteSourceSpoonacular>>>()
    val recipeResult: LiveData<Event<Resource<RemoteSourceSpoonacular>>> = _recipeResult
    init {
        getSearchRecipe()
    }
    private fun getSearchRecipe(){
        _recipeResult.value = Event(Resource.loading(null))
        viewModelScope.launch {
            Log.w("VMVM", "In coroutine ")
            val response = repo.searchRecipes()
            Log.w("RERE", response.toString())
            _recipeResult.value = Event(response)
        }
    }
    fun makeIds(i: Int){
        count++
        if(count<=i){makeIds(predaciteNum)}
    }

}