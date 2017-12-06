package com.kkoza.starter.signup
import com.kkoza.starter.user.User
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/signup")
class SignUpEndpoint(val template: MongoTemplate) {

    @PostMapping
    fun signup(@RequestBody user: User): ResponseEntity<HttpStatus> {
        template.save(user)
        return ResponseEntity(HttpStatus.OK)
    }
}