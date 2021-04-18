package com.example.keycloakadmin.controller;

import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.keycloakadmin.model.KeycloakUserDTO;
import com.example.keycloakadmin.service.KeycloakService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

  private final KeycloakService keycloakService;

  @PostMapping
  public Response createUser(@RequestBody KeycloakUserDTO userDTO) {
    return keycloakService.createUser(userDTO);
  }

  @PutMapping
  public void updateUser(@RequestBody KeycloakUserDTO userDTO, @RequestParam String userId) {
    keycloakService.updateUser(userDTO, userId);
  }
  
  @DeleteMapping("{userId}")
  public Response removeUser(@PathVariable String userId) {
    return keycloakService.removeUser(userId);
  }
}
