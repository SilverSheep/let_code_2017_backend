package com.kkoza.starter.grade

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "grade")
data class Grade (
        @Id
        val id: String? = null,
        val value: Int,
        val comment: String,
        val voterId: String,
        val voterName: String,
        val voterAge: Int
)