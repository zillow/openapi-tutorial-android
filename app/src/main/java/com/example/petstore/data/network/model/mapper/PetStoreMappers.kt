package com.example.petstore.data.network.model.mapper

import com.example.petstore.domain.model.PetDomainModel
import com.example.petstore.domain.model.PetStoreDomainModel
import com.example.petstore.shared.models.Pet
import com.example.petstore.store.models.StoreInfo

fun Pet.toDomain() = PetDomainModel(
    id = id,
    name = name,
    age = age,
    type = type
)

fun StoreInfo.toDomain() = PetStoreDomainModel(
    phoneNumber = phoneNumber,
    address = address,
    recentPets = recentPets.map { it.toDomain() }
)