package com.example.kotlin.util

object StringUtils {
    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
                .map { charset.random() }
                .joinToString("")
    }
}