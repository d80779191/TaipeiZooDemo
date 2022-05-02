package com.taipeizoodemo.base

import com.taipeizoodemo.area.model.AreaResponse
import com.taipeizoodemo.vegetation.model.VegetationResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethod {

    // 取得館區列表
    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    fun getAreaList(): Call<AreaResponse>

    // 取得植物列表
    @GET("api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14?scope=resourceAquire")
    fun getVegetationList(): Call<VegetationResponse>
}