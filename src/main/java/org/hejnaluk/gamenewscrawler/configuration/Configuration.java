package org.hejnaluk.gamenewscrawler.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hejnaluk.gamenewscrawler.service.HttpRequestExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${REDIS_URL}")
    String REDIS_URL;

    @Bean
    public XmlMapper xmlMapperBean() {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return xmlMapper;
    }

    @Bean
    public HttpRequestExecutor httpRequestExecutorBean() {
        HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutor();

        return httpRequestExecutor;
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(REDIS_URL, 6379));
    }
}
