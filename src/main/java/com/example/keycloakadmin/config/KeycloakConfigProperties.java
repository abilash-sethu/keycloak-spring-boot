package com.example.keycloakadmin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "keycloak.admin")
public class KeycloakConfigProperties {
  
  private String keycloakUrl;
  
  private String adminUser;
  
  private String adminPassword;
  
  private String realm;

  private String adminClientId;
}
