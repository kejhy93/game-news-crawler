package org.hejnaluk.gamenewscrawler.configuration;

import org.hejnaluk.gamenewscrawler.data.EntryDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@org.springframework.context.annotation.Configuration
class RedisConfiguration {

    @Value("${REDIS_URL}")
    String REDIS_URL;

    Logger logger = LoggerFactory.getLogger(RedisConfiguration.class.getName());

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        URI redisURI = URI.create(REDIS_URL);
        logger.info("Redis info " + REDIS_URL);
        logger.info("Redis info " + redisURI.getHost() + ":" + redisURI.getPort());

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisURI.getHost());
        redisStandaloneConfiguration.setPort(redisURI.getPort());
        redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setPassword(redisURI.getUserInfo() == null ? null : redisURI.getUserInfo().split(":",2)[1]);

        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(redisStandaloneConfiguration);

        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, EntryDb> redisTemplate() {
        RedisTemplate<String, EntryDb> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}