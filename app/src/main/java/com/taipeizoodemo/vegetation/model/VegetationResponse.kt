package com.taipeizoodemo.vegetation.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class VegetationResponse(

	@field:JsonProperty("result")
	val result: Result? = null
) {
	@JsonIgnoreProperties(ignoreUnknown = true)
	data class Result(

		@field:JsonProperty("offset")
		val offset: Int? = null,

		@field:JsonProperty("limit")
		val limit: Int? = null,

		@field:JsonProperty("count")
		val count: Int? = null,

		@field:JsonProperty("sort")
		val sort: String? = null,

		@field:JsonProperty("results")
		val results: List<ResultsItem?>? = null
	) {
		@JsonIgnoreProperties(ignoreUnknown = true)
		data class ResultsItem(

			@field:JsonProperty("﻿F_Name_Ch") // TODO 資料Key值亂碼，若修復需改欄位名稱
			val fNameCh: String? = null,

			@field:JsonProperty("F_Name_En")
			val fNameEn: String? = null,

			@field:JsonProperty("F_pdf02_ALT")
			val fPdf02ALT: String? = null,

			@field:JsonProperty("F_Voice01_URL")
			val fVoice01URL: String? = null,

			@field:JsonProperty("F_Name_Latin")
			val fNameLatin: String? = null,

			@field:JsonProperty("F_Pic04_URL")
			val fPic04URL: String? = null,

			@field:JsonProperty("F_Summary")
			val fSummary: String? = null,

			@field:JsonProperty("F_Brief")
			val fBrief: String? = null,

			@field:JsonProperty("F_Location")
			val fLocation: String? = null,

			@field:JsonProperty("F_Pic03_ALT")
			val fPic03ALT: String? = null,

			@field:JsonProperty("F_pdf02_URL")
			val fPdf02URL: String? = null,

			@field:JsonProperty("F_Voice01_ALT")
			val fVoice01ALT: String? = null,

			@field:JsonProperty("F_Voice02_URL")
			val fVoice02URL: String? = null,

			@field:JsonProperty("F_Voice02_ALT")
			val fVoice02ALT: String? = null,

			@field:JsonProperty("F_Pic01_URL")
			val fPic01URL: String? = null,

			@field:JsonProperty("F_Pic02_ALT")
			val fPic02ALT: String? = null,

			@field:JsonProperty("F_Keywords")
			val fKeywords: String? = null,

			@field:JsonProperty("F_Family")
			val fFamily: String? = null,

			@field:JsonProperty("F_CID")
			val fCID: String? = null,

			@field:JsonProperty("F_Pic01_ALT")
			val fPic01ALT: String? = null,

			@field:JsonProperty("F_Pic02_URL")
			val fPic02URL: String? = null,

			@field:JsonProperty("F_Update")
			val fUpdate: String? = null,

			@field:JsonProperty("F_Voice03_URL")
			val fVoice03URL: String? = null,

			@field:JsonProperty("F_Code")
			val fCode: String? = null,

			@field:JsonProperty("F_Function＆Application")
			val fFunctionApplication: String? = null,

			@field:JsonProperty("F_Voice03_ALT")
			val fVoice03ALT: String? = null,

			@field:JsonProperty("F_Pic03_URL")
			val fPic03URL: String? = null,

			@field:JsonProperty("F_Vedio_URL")
			val fVedioURL: String? = null,

			@field:JsonProperty("F_pdf01_ALT")
			val fPdf01ALT: String? = null,

			@field:JsonProperty("F_AlsoKnown")
			val fAlsoKnown: String? = null,

			@field:JsonProperty("F_pdf01_URL")
			val fPdf01URL: String? = null,

			@field:JsonProperty("_id")
			val id: Int? = null,

			@field:JsonProperty("F_Feature")
			val fFeature: String? = null,

			@field:JsonProperty("F_Genus")
			val fGenus: String? = null,

			@field:JsonProperty("F_Pic04_ALT")
			val fPic04ALT: String? = null,

			@field:JsonProperty("F_Geo")
			val fGeo: String? = null
		)
	}
}
