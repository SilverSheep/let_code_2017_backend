package com.kkoza.starter.login

import com.kkoza.starter.user.User
import com.kkoza.starter.user.UserFacade
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/login")
class LoginEndpoint(val userFacade: UserFacade) {

    @PostMapping()
    fun login(@RequestBody loginData: LoginData): ResponseEntity<User> {

        val user = userFacade.findUserByLogin(loginData.login) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)

        println("login:")
        println(loginData.login)
        println("password:")
        println(loginData.password)
        return if (user.password == loginData.password) ResponseEntity(user, HttpStatus.OK) else ResponseEntity(HttpStatus.UNAUTHORIZED)
    }
}

class LoginData {
    val login: String = ""
    val password: String = ""
}
