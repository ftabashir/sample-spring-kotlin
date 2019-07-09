package com.example.demo1.user

import org.springframework.data.annotation.Id

data class UserModel(val name: String, val age: Int) {
    @Id
    var id: String? = null
}