package com.example.petstore.data.network.model.mapper

import com.example.petstore.data.network.model.PetNetworkModel
import com.example.petstore.data.network.model.StoreInfoNetworkModel
import com.example.petstore.data.network.model.StorePetNetworkModel
import com.example.petstore.domain.model.PetDomainModel
import com.example.petstore.domain.model.PetStoreDomainModel

fun PetNetworkModel.toDomain() = PetDomainModel(
    id = id,
    name = name,
    age = age,
    type = type
)

fun StorePetNetworkModel.toDomain() = PetDomainModel(
    id = id,
    name = name,
    age = age,
    type = type
)

fun StoreInfoNetworkModel.toDomain() = PetStoreDomainModel(
    phoneNumber = phoneNumber,
    address = address,
    recentPets = pets.map { it.toDomain() }
)