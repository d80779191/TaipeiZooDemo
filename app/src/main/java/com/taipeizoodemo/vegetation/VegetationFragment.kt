package com.taipeizoodemo.vegetation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.taipeizoodemo.AREA_DATA_TO_DETAIL
import com.taipeizoodemo.AREA_DATA_TO_VEGETATION
import com.taipeizoodemo.BR
import com.taipeizoodemo.R
import com.taipeizoodemo.databinding.FragmentVegetationBinding
import com.taipeizoodemo.vegetation.model.VegetationResponse

class VegetationFragment: Fragment() {
    private lateinit var binding: FragmentVegetationBinding
    private lateinit var areaData: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_vegetation, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        areaData = arguments?.getString(AREA_DATA_TO_DETAIL).toString()
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val vegetationDetail: VegetationResponse.Result.ResultsItem = Gson().fromJson(arguments?.getString(
            AREA_DATA_TO_VEGETATION
        ), VegetationResponse.Result.ResultsItem::class.java)
        initVegetationDetail(vegetationDetail)
    }

    private fun initVegetationDetail(vegetationDetail: VegetationResponse.Result.ResultsItem) {
        binding.setVariable(BR.vegetationDetail, vegetationDetail)
        if (vegetationDetail.fPic01URL != null) {
            Glide.with(requireActivity())
                .load(vegetationDetail.fPic01URL)
                .into(binding.ivVegetationPic)
        }
    }
}