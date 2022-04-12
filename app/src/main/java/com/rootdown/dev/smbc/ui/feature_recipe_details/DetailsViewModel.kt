package com.rootdown.dev.smbc.ui.feature_recipe_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    private var currId by Delegates.notNull<Int>()
    var xx: RemoteSourceSpoonacular.Result? = null
    private val _resultCurr = MutableLiveData<RemoteSourceSpoonacular.Result>()
    val resultCurr: LiveData<RemoteSourceSpoonacular.Result> = _resultCurr
    fun setId(id: Int){
        currId = id
    }
    fun setCurrentSelection(curr: RemoteSourceSpoonacular.Result){
        Log.w("AAA", curr.toString())
        _resultCurr.postValue(curr)
    }
}