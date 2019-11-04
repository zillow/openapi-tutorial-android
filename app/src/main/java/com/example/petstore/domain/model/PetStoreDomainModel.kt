package com.example.petstore.domain.model

data class PetStoreDomainModel(

    val phoneNumber: String,

    val address: String,

    val recentPets: List<PetDomainModel>

)