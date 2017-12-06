package com.kkoza.starter.math

import org.springframework.stereotype.Service
import java.lang.Math.*

const val EARTH_R = 6372800 // in meters

@Service
class MathService {

    /**
     * haversine formula
     *
     * result is in meters
     */
    fun calculateDistanceOnEarth(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val λ1 = toRadians(lat1)
        val λ2 = toRadians(lat2)
        val Δλ = toRadians(lat2 - lat1)
        val Δφ = toRadians(lon2 - lon1)
        return 2 * EARTH_R * asin(sqrt(pow(sin(Δλ / 2), 2.0) + pow(sin(Δφ / 2), 2.0) * cos(λ1) * cos(λ2)))
    }
}