package com.example.keycloakadmin.config;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JacksonConfig {

  private final ObjectMapper objectMapper;
  
  @PostConstruct
  public void configure() {
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
  }
}
