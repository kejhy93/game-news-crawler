package org.hejnaluk.gamenewscrawler.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hejnaluk.gamenewscrawler.service.HttpRequestExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

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

}
