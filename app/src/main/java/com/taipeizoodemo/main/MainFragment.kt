package com.taipeizoodemo.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import com.lxj.xpopup.XPopup
import com.taipeizoodemo.R
import com.taipeizoodemo.base.RetrofitX
import com.taipeizoodemo.databinding.FragmentMainBinding
import retrofit2.await

class MainFragment: Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: MainListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAreaList()
    }

    private fun getAreaList() {
        lifecycle.coroutineScope.launchWhenCreated {
            try {
                val areaResponse = RetrofitX().API_METHOD.getAreaList().await()
                if (areaResponse.result?.results != null) {
                    adapter = MainListAdapter()
                    adapter.setAreaList(areaResponse.result.results)
                    binding.recyclerMain.adapter = adapter
                }
            } catch (e: Throwable) {
                XPopup.Builder(requireActivity())
                    .asConfirm(getString(R.string.dialog_failed_title)
                        , getString(R.string.dialog_failed_area_hint)
                        , getString(R.string.dialog_cancel)
                        , getString(R.string.dialog_confirm)
                        , {}, {}, true).show()
            }
        }
    }
}