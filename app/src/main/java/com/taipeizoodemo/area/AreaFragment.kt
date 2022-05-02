package com.taipeizoodemo.area

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.lxj.xpopup.XPopup
import com.taipeizoodemo.AREA_DATA_TO_DETAIL
import com.taipeizoodemo.BR
import com.taipeizoodemo.R
import com.taipeizoodemo.area.model.AreaResponse
import com.taipeizoodemo.base.RetrofitX
import com.taipeizoodemo.databinding.FragmentAreaBinding
import com.taipeizoodemo.vegetation.model.VegetationResponse
import retrofit2.await


class AreaFragment: Fragment() {
    private lateinit var binding: FragmentAreaBinding
    private lateinit var adapter: AreaVegetationListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_area, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val areaDetail: AreaResponse.Result.ResultsItem = Gson().fromJson(arguments?.getString(AREA_DATA_TO_DETAIL), AreaResponse.Result.ResultsItem::class.java)
        initAreaDetail(areaDetail)
        getVegetationList()
    }

    private fun initAreaDetail(areaDetail: AreaResponse.Result.ResultsItem) {
        binding.setVariable(BR.areaDetail, areaDetail)
        if (areaDetail.ePicURL != null) {
            Glide.with(requireActivity())
                .load(areaDetail.ePicURL)
                .into(binding.ivAreaPic)
        }

        if (areaDetail.eURL != null) {
            binding.tvAreaLink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(areaDetail.eURL)
                startActivity(intent)
            }
        }
    }

    private fun getVegetationList() {
        lifecycle.coroutineScope.launchWhenCreated {
            try {
                val vegetationResponse = RetrofitX().API_METHOD.getVegetationList().await()
                if (vegetationResponse.result?.results != null) {
                    adapter = AreaVegetationListAdapter()
                    adapter.setAreaData(arguments?.getString(AREA_DATA_TO_DETAIL).orEmpty())
                    // 篩選有在區域內的植物
                    val inAreaList: MutableList<VegetationResponse.Result.ResultsItem> = mutableListOf()
                    vegetationResponse.result.results.forEach {
                        if (it?.fLocation?.contains(binding.tvTitle.text) == true) {
                            inAreaList.add(it)
                        }
                    }
                    adapter.setVegetationList(inAreaList)
                    binding.recyclerArea.adapter = adapter
                }
            } catch (e: Throwable) {
                XPopup.Builder(requireActivity())
                    .asConfirm(getString(R.string.dialog_failed_title)
                        , getString(R.string.dialog_failed_vegetation_hint)
                        , getString(R.string.dialog_cancel)
                        , getString(R.string.dialog_confirm)
                        , {}, {}, true).show()
            }
        }
    }
}