package com.kkoza.starter.route

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/routes")
class RouteEndpoint(val template: MongoTemplate, val routeFacade: RouteFacade) {

    @GetMapping()
    fun getAllRoutes(): ResponseEntity<List<Route>> {
        val allRoutes = template.findAll(Route::class.java)
        return ResponseEntity(allRoutes, HttpStatus.OK)
    }

    @GetMapping("/{routeId}")
    fun getRouteById(@PathVariable routeId: String): ResponseEntity<Route> {
        val route = template.findById(routeId, Route::class.java)
        return ResponseEntity(route, HttpStatus.OK)
    }

    @GetMapping("/search")
    fun getRoutesByLocation(@RequestParam startLat: Double,
                            @RequestParam startLon: Double,
                            @RequestParam endLat: Double,
                            @RequestParam endLon: Double,
                            @RequestParam radius: Int
    ): ResponseEntity<List<Route>> {

        return ResponseEntity(routeFacade.findRoutesByLocation(startLat, startLon, endLat, endLon, radius), HttpStatus.OK)
    }

    @PostMapping("/add")
    fun addRoute(@RequestBody route: Route): ResponseEntity<HttpStatus> {
        template.save(route)
        return ResponseEntity(HttpStatus.OK)
    }
}