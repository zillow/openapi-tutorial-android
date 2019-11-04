package com.example.petstore.domain.error

class PetStoreError(code: Int, message: String) : Exception("Error code $code: $message")