package com.example.kotlin.controller

import com.example.kotlin.dao.UserDao
import com.example.kotlin.model.User
import com.example.kotlin.request.UserRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UserController {

    @Autowired
    lateinit var userDao: UserDao

    @GetMapping("/users")
    fun index(): ResponseEntity<Iterable<User>> {
        return ResponseEntity.ok(userDao.findAll())
    }

    @GetMapping("/users/{id}")
    fun show(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(userDao.findById(id).get())
    }

    @PutMapping("/users/{id}")
    fun update(@PathVariable id: Long, @RequestBody userRequest: UserRequest): ResponseEntity<User> {
        val user = userDao.findById(id)
        val updatedUser = userDao.save(User(
                id = user.get().id,
                fullName = userRequest.fullname,
                email = userRequest.email,
                password = userRequest.password,
                createDate = user.get().createDate,
                updateDate = Date()
        ))
        return ResponseEntity.ok(updatedUser)
    }

    @DeleteMapping("/users/{id}")
    fun destroy(@PathVariable id: Long): ResponseEntity<User> {
        userDao.deleteById(id)
        return ResponseEntity(HttpStatus.OK)
    }
}