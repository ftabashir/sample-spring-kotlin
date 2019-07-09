package com.example.demo1.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(var repo: UserRepo) {

    @PostMapping("add")
    fun add(@RequestBody user: UserModel) = repo.run {
        insert(user)
        findAll()
    }

}