package org.hejnaluk.gamenewscrawler.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.net.URI;
import java.net.URISyntaxException;

import static io.lettuce.core.ReadFrom.REPLICA_PREFERRED;

@org.springframework.context.annotation.Configuration
class RedisConfiguration {

    @Bean
    public JedisPool getJedisPool() {
        try {
            URI redisURI = new URI(System.getenv("REDIS_URL"));
            return new JedisPool(new JedisPoolConfig(),
                    redisURI.getHost(),
                    redisURI.getPort(),
                    Protocol.DEFAULT_TIMEOUT,
                    redisURI.getUserInfo().split(":",2)[1]);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Redis couldn't be configured from URL in REDIS_URL env var:"+
                    System.getenv("REDIS_URL"));
        }
    }
}