package com.taipeizoodemo.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.taipeizoodemo.AREA_DATA_TO_DETAIL
import com.taipeizoodemo.BR
import com.taipeizoodemo.R
import com.taipeizoodemo.area.model.AreaResponse
import com.taipeizoodemo.databinding.ItemMainBinding

class MainListAdapter: RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {
    private lateinit var areaList: List<AreaResponse.Result.ResultsItem?>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        return MainListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.itemBinding.setVariable(BR.itemAreaData, areaList[position])
        if (areaList[position]?.ePicURL != null) {
            Glide.with(holder.itemBinding.ivPic.context)
                .load(areaList[position]?.ePicURL)
                .into(holder.itemBinding.ivPic)
        }
        holder.itemView.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putString(AREA_DATA_TO_DETAIL, Gson().toJson(areaList[position]))
            view.findNavController().navigate(R.id.action_main_to_area, bundle)
        }
    }

    override fun getItemCount(): Int {
        return areaList.count()
    }

    fun setAreaList(areaList: List<AreaResponse.Result.ResultsItem?>) {
        this.areaList = areaList
        notifyDataSetChanged()
    }

    class MainListViewHolder(var itemBinding: ItemMainBinding): RecyclerView.ViewHolder(itemBinding.root)
}