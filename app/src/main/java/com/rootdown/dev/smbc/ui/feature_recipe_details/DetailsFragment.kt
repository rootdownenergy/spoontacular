package com.rootdown.dev.smbc.ui.feature_recipe_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rootdown.dev.smbc.R
import com.rootdown.dev.smbc.databinding.FragmentDetailsBinding
import com.rootdown.dev.smbc.ui.feature_recipe_list.RecipeListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    val vm: DetailsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        Log.w("VVV", "In on create details fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.w("VVV", "In oncreateview")
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        val img: ImageView = binding.detailImgId
        vm.resultCurr.observe(viewLifecycleOwner, Observer {
            val it_detail_img = it.image
            val url = "$it_detail_img"
            Log.w("url", url)
            if(it_detail_img!!.isNotEmpty()){
                Glide.with(this)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(img)
            }
            binding.detailNameId.text = it.title
        })
        return view
    }
}