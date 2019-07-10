package com.example.demo1.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(var repo: UserRepo, val redisCacheManager: RedisCacheManager) {

    private val COUNT = "count"
    private val usersCache by lazy { redisCacheManager.getCache("users_cache")!! }
    private fun increaseCount() = usersCache.put(COUNT, getCount() + 1)
    private fun getCount(): Long {
        val cachedCount = usersCache.get(COUNT)
        if (cachedCount == null) {
            println("read count from db")
            return repo.count().also { usersCache.put(COUNT, it) }
        } else {
            println("read count from cache")
            return cachedCount.get() as Long
        }
    }

    @PostMapping("add")
    fun add(@RequestBody user: UserModel) = repo.run {
        insert(user)
        increaseCount()
        findAll()
    }

    @GetMapping("all")
    fun all() = repo.findAll()

    @GetMapping("count")
    fun count() = getCount()
}