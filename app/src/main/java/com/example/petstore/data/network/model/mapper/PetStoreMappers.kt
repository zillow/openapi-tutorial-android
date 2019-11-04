package com.example.petstore.data.network.model.mapper

import com.example.petstore.domain.model.PetDomainModel
import com.example.petstore.domain.model.PetStoreDomainModel
import com.example.petstore.pets.models.Pet
import com.example.petstore.store.models.StoreInfo
import com.example.petstore.store.models.Pet as StorePet

fun Pet.toDomain() = PetDomainModel(
    id = id,
    name = name,
    age = age,
    type = type
)

fun StorePet.toDomain() = PetDomainModel(
    id = petId,
    name = petName,
    age = petAge,
    type = petType
)

fun StoreInfo.toDomain() = PetStoreDomainModel(
    phoneNumber = phoneNumber,
    address = address,
    recentPets = recentPets.map { it.toDomain() }
)