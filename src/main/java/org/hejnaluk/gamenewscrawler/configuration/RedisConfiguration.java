package org.hejnaluk.gamenewscrawler.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.net.URI;
import java.net.URISyntaxException;

@org.springframework.context.annotation.Configuration
class RedisConfiguration {

    @Value("${REDIS_URL}")
    String REDIS_URL;

    Logger logger = LoggerFactory.getLogger(RedisConfiguration.class.getName());

    @Bean
    public JedisPool getJedisPool() {
        URI redisURI = URI.create(REDIS_URL);
        logger.info("Redis info " + REDIS_URL);
        logger.info("Redis info " + redisURI.getHost() + ":" + redisURI.getPort());
        JedisPool jedisPool= new JedisPool(new JedisPoolConfig(),
                redisURI.getHost(),
                redisURI.getPort(),
                Protocol.DEFAULT_TIMEOUT,
                redisURI.getUserInfo() == null ? null : redisURI.getUserInfo().split(":",2)[1]);


        return jedisPool;
    }
}