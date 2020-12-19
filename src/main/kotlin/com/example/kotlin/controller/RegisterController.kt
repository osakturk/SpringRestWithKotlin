package com.example.kotlin.controller

import com.example.kotlin.dao.UserDao
import com.example.kotlin.model.User
import com.example.kotlin.request.UserRequest
import com.example.kotlin.util.HashUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterController {

   @Autowired
   lateinit var userDao: UserDao

    @PostMapping("/register")
    fun register(@RequestBody userRequest: UserRequest): ResponseEntity<User>{
        userDao.save(User(
                fullName = userRequest.fullname,
                email = userRequest.email,
                password = HashUtils.sha512(userRequest.password)
        ))
        return ResponseEntity(HttpStatus.CREATED)
    }
}