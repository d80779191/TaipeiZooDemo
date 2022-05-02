package com.taipeizoodemo.area.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AreaResponse(

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

			@field:JsonProperty("E_Pic_URL")
			val ePicURL: String? = null,

			@field:JsonProperty("E_Info")
			val eInfo: String? = null,

			@field:JsonProperty("E_Category")
			val eCategory: String? = null,

			@field:JsonProperty("E_Memo")
			val eMemo: String? = null,

			@field:JsonProperty("_id")
			val id: Int? = null,

			@field:JsonProperty("E_no")
			val eNo: String? = null,

			@field:JsonProperty("E_Name")
			val eName: String? = null,

			@field:JsonProperty("E_URL")
			val eURL: String? = null,

			@field:JsonProperty("E_Geo")
			val eGeo: String? = null
		)
	}
}
