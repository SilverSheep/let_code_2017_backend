package com.kkoza.starter.route

import com.kkoza.starter.math.MathService
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class RouteFacade(val template: MongoTemplate, val mathService: MathService) {

    fun findRoutesByLocation(startLat: Double, startLon: Double, endLat: Double, endLon: Double, radius: Int): List<Route> {
        val routes = template.findAll(Route::class.java)

        val filteredRoutes = routes.filter { it ->
            (mathService.calculateDistanceOnEarth(startLat, startLon, it.startLat, it.startLon) <= radius) &&
                    (mathService.calculateDistanceOnEarth(endLat, endLon, it.endLat, it.endLon) <= radius)
        }

        return filteredRoutes
    }

}