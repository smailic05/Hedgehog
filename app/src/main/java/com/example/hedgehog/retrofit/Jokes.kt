package com.example.hedgehog.retrofit

import com.google.gson.annotations.SerializedName

data class Jokes(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("value")
	val value: List<ValueItem?>? = null
)

data class ValueItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("joke")
	val joke: String? = null
)
