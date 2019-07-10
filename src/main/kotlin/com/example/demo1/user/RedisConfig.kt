package com.example.demo1.user

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import java.time.Duration

@Configuration
class RedisConfig {

    @Bean
    fun cacheConfiguration() = RedisCacheConfiguration
            .defaultCacheConfig()
            .entryTtl(Duration.ofSeconds(600))
            .disableCachingNullValues()


    @Bean
    fun cacheManager(redisConnectionFactory: RedisConnectionFactory) = RedisCacheManager.builder(redisConnectionFactory)
            .cacheDefaults(cacheConfiguration())
            .transactionAware()
            .build()

}