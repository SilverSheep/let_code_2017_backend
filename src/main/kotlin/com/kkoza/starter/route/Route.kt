package com.kkoza.starter.route

import com.fasterxml.jackson.annotation.JsonFormat
import org.joda.time.DateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "route")
data class Route(
        @Id
        val id: String? = null,
        val userId: String,
        val userName: String,
        val userPhone: String,
        val userAge: Int,
        val startLon: Double,
        val startLat: Double,
        val endLon: Double,
        val endLat: Double,
        val startPlaceName: String,
        val endPlaceName: String,
        @JsonFormat(pattern = "HH:mm:ss") val hour: DateTime,
        val dayOfWeek: List<String>
        )