package com.example.kotlin.dao

import com.example.kotlin.model.User
import org.springframework.data.repository.CrudRepository


interface UserDao: CrudRepository<User,Long> {
}