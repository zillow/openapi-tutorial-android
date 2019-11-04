package com.example.petstore.data.network.model

import com.google.gson.annotations.SerializedName

data class StoreInfoNetworkModel(

    @SerializedName("phoneNumber")
    val phoneNumber: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("recentPets")
    val pets: List<StorePetNetworkModel>

)