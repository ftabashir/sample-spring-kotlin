package com.example.demo1.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping("/{name}")
    fun byName(@PathVariable(value = "name") name: String) = "Hello $name"

}