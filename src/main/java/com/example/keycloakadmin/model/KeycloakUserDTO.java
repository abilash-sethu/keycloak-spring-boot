package com.example.keycloakadmin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KeycloakUserDTO {

  private String userId;
  
  private String username;
  
  private String firstname;
  
  private String lastname;
  
  private String email;
  
  private String password;
  
  private Boolean isEnabled;
  
  
}
