package com.kkoza.starter.user
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/users")
class UserEndpoint(val template: MongoTemplate, val userFacade: UserFacade) {

    @GetMapping()
    fun getAllUsers(): ResponseEntity<List<User>> {
        val allUsers = template.findAll(User::class.java)
        return ResponseEntity(allUsers, HttpStatus.OK)
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String): ResponseEntity<User> {
        val user = template.findById(userId, User::class.java)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @GetMapping("/login/{userLogin}")
    fun getUserByLogin(@PathVariable userLogin: String): ResponseEntity<User?> {
        val user = userFacade.findUserByLogin(userLogin)
        return ResponseEntity(user, HttpStatus.OK)
    }
}