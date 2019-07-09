package com.example.demo1.user

import org.springframework.data.mongodb.repository.MongoRepository


interface UserRepo : MongoRepository<UserModel, Long>