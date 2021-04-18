package com.example.keycloakadmin.model;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KeycloakUserDTOToUserRepresentationConverter
    implements Converter<KeycloakUserDTO, UserRepresentation> {

  @Override
  public UserRepresentation convert(KeycloakUserDTO source) {
    UserRepresentation user = new UserRepresentation();
    user.setUsername(source.getUsername());
    user.setFirstName(source.getFirstname());
    user.setLastName(source.getLastname());
    user.setEmail(source.getEmail());
    user.setEnabled(source.getIsEnabled());
    return user;
  }

}
