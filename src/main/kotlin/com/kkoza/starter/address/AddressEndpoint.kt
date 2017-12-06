package com.kkoza.starter.address

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/addresses")
class AddressEndpoint(val template: MongoTemplate) {

    @GetMapping()
    fun getAllAddresses(): ResponseEntity<List<Address>> {
        val allAddresses = template.findAll(Address::class.java)
        return ResponseEntity(allAddresses, HttpStatus.OK)
    }

    @GetMapping("/{addressId}")
    fun getAddressById(@PathVariable addressId: String): ResponseEntity<Address> {
        val address = template.findById(addressId, Address::class.java)
        return ResponseEntity(address, HttpStatus.OK)
    }
}