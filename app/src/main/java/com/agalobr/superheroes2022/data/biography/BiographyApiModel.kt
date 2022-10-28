package com.agalobr.superheroes2022.data.biography

import com.google.gson.annotations.SerializedName

data class BiographyApiModel(@SerializedName("fullName") val fullName: String)