package com.rootdown.dev.smbc.ui.feature_recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.rootdown.dev.smbc.data.model.remote.RemoteSourceComplexSearch
import com.rootdown.dev.smbc.databinding.FragmentSearchListBinding
import com.rootdown.dev.smbc.recipe
import com.rootdown.dev.smbc.ui.feature_recipe_details.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    private lateinit var binding: FragmentSearchListBinding
    val vm: RecipeListViewModel by activityViewModels()
    val vmDetail: DetailsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchListBinding.inflate(inflater)
        val epoxyView: EpoxyRecyclerView = binding.rvTask
        vm.recipeResultComplex.observe(viewLifecycleOwner) {
            Log.w("XXX", it.toString())
            it?.let {
                val x = it.getContent().data
                    val y = it.getContent()
                    Log.w("$$$", y.toString())
                    val ls: List<RemoteSourceComplexSearch.Result?> = (y.data?.results ?: listOf(RemoteSourceComplexSearch.Result(
                        calories = 12,
                        carbs = "error",
                        fat = "error",
                        id = 1,
                        image = "err",
                        imageType = "err",
                        protein = "err",
                        title = "err"
                    )))
                    setupEpoxy(ls,epoxyView)
            }
        }
        return binding.root
    }

    private fun setupEpoxy(result: List<RemoteSourceComplexSearch.Result?>, epoxy: EpoxyRecyclerView){
        val xLs = result
        vm.predaciteNum = xLs.size
        //xLs.first()?.image
        var lsEpoxy: List<RemoteSourceComplexSearch.Result> = listOf()
        if(result.isEmpty()){
            lsEpoxy = listOf(RemoteSourceComplexSearch.Result(
                calories = 12,
                carbs = "error",
                fat = "error",
                id = 1,
                image = "err",
                imageType = "err",
                protein = "err",
                title = "err"
            ))
        } else {
            lsEpoxy = result as List<RemoteSourceComplexSearch.Result>
        }
        epoxy.withModels {
            lsEpoxy.forEach { xx ->
                vm.makeIds(vm.predaciteNum)
                recipe {
                    id(vm.count)
                    xx(xx)
                    clickListener { x ->
                        Log.w("CCC", xx.toString())
                        vmDetail.setCurrentSelection(xx)
                        val action = RecipeListFragmentDirections.actionRecipeListFragmentToDetailsFragment()
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}