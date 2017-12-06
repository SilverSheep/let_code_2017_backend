package com.kkoza.starter.grade

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/grades")
class GradeEndpoint(val template: MongoTemplate) {

        @GetMapping()
        fun getAllGrades(): ResponseEntity<List<Grade>> {
                val allGrades = template.findAll(Grade::class.java)
                return ResponseEntity(allGrades, HttpStatus.OK)
        }

        @GetMapping("/{gradeId}")
        fun getGradeById(@PathVariable gradeId: String): ResponseEntity<Grade> {
                val grade = template.findById(gradeId, Grade::class.java)
                return ResponseEntity(grade, HttpStatus.OK)
        }

        @PostMapping("/add")
        fun addGrade(@RequestBody grade: Grade): ResponseEntity<HttpStatus> {
                template.save(grade)
                return ResponseEntity(HttpStatus.OK)
        }
}