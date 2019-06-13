package io.uetunited.oneheed.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RestTemplateConfig
 */
@Configuration
public class MapperConfig {

    @Bean
    public ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        return mapper;
    }
}