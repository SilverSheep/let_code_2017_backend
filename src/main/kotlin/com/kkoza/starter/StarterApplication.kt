package com.kkoza.starter

import com.kkoza.starter.address.Address
import com.kkoza.starter.grade.Grade
import com.kkoza.starter.route.Route
import com.kkoza.starter.user.User
import org.bson.types.ObjectId
import org.joda.time.DateTime
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoTemplate

@SpringBootApplication
class StarterApplication(
        val template: MongoTemplate
) {

    @Bean
    fun init() = CommandLineRunner {

        // sample data to add to db
        val voterId = ObjectId()
        val driverId = ObjectId()

        val grade = Grade(null, 5, "Nice ride", voterId.toString(), "Agnieszka", 34)

        val user = User(driverId.toString(), "Kapitan", "Bomba", "http://img.cda.pl/vid/oryginalne/14044689761786-131.jpg", "M",
                DateTime(1960, 5, 13, 0, 0), "Majami", "66666666", "bomba@kapitan.com",
                Address(null, "ul. Fajowa", "Kosmos", "13A", "3", "54-666"),
                "bomba", "password", listOf(grade))

        val voter = User(voterId.toString(), "Agnieszka", "Bomba", "http://ocdn.eu/pulscms-transforms/1/kF1ktkpTURBXy9lNzQ2ODIyMzQ5NGFjYjNjNDc1ODg3NTU0ZjhiNjNmNi5qcGeSlQMBzQQPzQ9FzQiWkwXNAwzNAWg",
                "K", DateTime(1966, 3, 4, 0, 0), "Polsa", "211232232", "agnieszka@bomba.com",
                Address(null, "ul. MOja", "Wrocław", "21", "3", "51-666"),
                "aga", "password", emptyList())

        val route = Route(null, driverId.toString(), "Kapitan", "66666666", 50, 53.000023, 32.3279, 23.4324, 32.4344, "cos", "Narnia", DateTime.now(), listOf("mo", "tu", "we", "th", "fr", "sa", "su"))
        val routeSwMarcin = Route(null, driverId.toString(), "Kapitan", "66666666", 50, 16.8987602, 52.4145307, 23.424, 44.4344, "cos", "Sw MArcin", DateTime.now(), listOf("mo", "tu", "we", "th", "fr", "sa", "su"))
        val newRoute = Route(null, driverId.toString(), "Kapitan", "66666666", 50, 21.134650899999997, 52.200167199999996, 16.929380299999995, 52.4023992, "cos", "Sw MArcin", DateTime.now(), listOf("mo", "tu", "we", "th", "fr", "sa", "su"))

        template.save(voter)
        template.save(grade)
        template.save(user)
        template.save(route)
        template.save(routeSwMarcin)
        template.save(newRoute)

        println(user)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(StarterApplication::class.java, *args)
}

