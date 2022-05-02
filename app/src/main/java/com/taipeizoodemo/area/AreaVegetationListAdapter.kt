package com.taipeizoodemo.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.taipeizoodemo.AREA_DATA_TO_DETAIL
import com.taipeizoodemo.AREA_DATA_TO_VEGETATION
import com.taipeizoodemo.BR
import com.taipeizoodemo.R
import com.taipeizoodemo.databinding.ItemVegetationBinding
import com.taipeizoodemo.vegetation.model.VegetationResponse

class AreaVegetationListAdapter: RecyclerView.Adapter<AreaVegetationListAdapter.AreaVegetationViewHolder>() {
    private lateinit var vegetationList: List<VegetationResponse.Result.ResultsItem?>
    private lateinit var areaData: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaVegetationViewHolder {
        return AreaVegetationViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_vegetation, parent, false))
    }

    override fun onBindViewHolder(holder: AreaVegetationViewHolder, position: Int) {
        holder.itemBinding.setVariable(BR.itemVegetationData, vegetationList[position])
        if (vegetationList[position]?.fPic01URL != null) {
            Glide.with(holder.itemBinding.ivPic.context)
                .load(vegetationList[position]?.fPic01URL)
                .into(holder.itemBinding.ivPic)
        }
        holder.itemView.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString(AREA_DATA_TO_DETAIL, areaData)
            bundle.putString(AREA_DATA_TO_VEGETATION, Gson().toJson(vegetationList[position]))
            view.findNavController().navigate(R.id.action_area_to_vegetation, bundle)
        }
    }

    override fun getItemCount(): Int {
        return vegetationList.count()
    }

    fun setVegetationList(vegetationList: List<VegetationResponse.Result.ResultsItem?>) {
        this.vegetationList = vegetationList
        notifyDataSetChanged()
    }

    fun setAreaData(areaData: String) {
        this.areaData = areaData
    }

    class AreaVegetationViewHolder(var itemBinding: ItemVegetationBinding): RecyclerView.ViewHolder(itemBinding.root)
}