package com.example.petstore.data.network.model

import com.google.gson.annotations.SerializedName

data class PetNetworkModel(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("type")
    val type: String

)