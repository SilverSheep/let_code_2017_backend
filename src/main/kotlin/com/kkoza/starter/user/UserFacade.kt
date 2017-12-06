package com.kkoza.starter.user

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service

@Service
class UserFacade(val template: MongoTemplate) {

    fun findUserByLogin(login: String): User? = template.findOne(Query(Criteria.where("login").`is`(login)), User::class.java)

}