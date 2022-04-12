package com.rootdown.dev.smbc.ui.feature_recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.rootdown.dev.smbc.data.model.remote.RemoteSourceSpoonacular
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
        vm.recipeResult.observe(viewLifecycleOwner) {
            Log.w("XXX", it.toString())
            it?.let {
                val x = it.getContent().data

                    val y = it.getContent()
                    Log.w("$$$", y.toString())
                    val ls: List<RemoteSourceSpoonacular.Result?> = y.data?.results ?: listOf(RemoteSourceSpoonacular.Result(id = 1, image = "", name = "Error"))
                    setupEpoxy(ls,epoxyView)
            }
        }
        return binding.root
    }

    private fun setupEpoxy(result: List<RemoteSourceSpoonacular.Result?>, epoxy: EpoxyRecyclerView){
        val xLs = result
        vm.predaciteNum = xLs.size
        //xLs.first()?.image

        var lsEpoxy: List<RemoteSourceSpoonacular.Result> = listOf()
        if(result.isEmpty()){
            lsEpoxy = listOf(RemoteSourceSpoonacular.Result(id = 1, image = "", name = "Error"))
        } else {
            lsEpoxy = result as List<RemoteSourceSpoonacular.Result>
        }
        epoxy.withModels {
            lsEpoxy.forEach { xx ->
                vm.makeIds(vm.predaciteNum)
                recipe {
                    id(vm.count)
                    vm(xx)
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