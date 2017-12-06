package com.kkoza.starter.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.kkoza.starter.address.Address
import com.kkoza.starter.grade.Grade
import org.joda.time.DateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
        @Id
        val id: String? = null,
        val firstName: String,
        val lastName: String,
        val photoUrl: String,
        val sex: String,
        val birthDate: DateTime,
        val city: String?,
        val phoneNumber: String,
        val email: String?,
        val livingAddress: Address?,
        val login: String,
        val password: String,
        val grades: List<Grade>
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Transient
    val age: Int = DateTime.now().year - birthDate.year
}