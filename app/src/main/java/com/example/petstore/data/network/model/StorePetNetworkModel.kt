package com.example.petstore.data.network.model

import com.google.gson.annotations.SerializedName

data class StorePetNetworkModel(

    @SerializedName("petId")
    val id: Long,

    @SerializedName("petName")
    val name: String,

    @SerializedName("petAge")
    val age: Int,

    @SerializedName("petType")
    val type: String

)