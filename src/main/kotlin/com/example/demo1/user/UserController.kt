package com.example.demo1.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    val users = mutableListOf<UserModel>()

    @PostMapping("add")
    fun add(@RequestBody user: UserModel) = users.also { it.add(user) }

}