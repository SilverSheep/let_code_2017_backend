package com.kkoza.starter.address

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "address")
data class Address (
        @Id
        val id: String? = null,
        val street: String,
        val city: String,
        val houseNumber: String,
        val flatNumber: String,
        val postalCode: String
)