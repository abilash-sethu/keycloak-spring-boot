package com.example.keycloakadmin.service;

import java.util.Arrays;
import javax.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.keycloakadmin.config.KeycloakConfigProperties;
import com.example.keycloakadmin.model.KeycloakUserDTO;
import com.example.keycloakadmin.model.KeycloakUserDTOToUserRepresentationConverter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KeycloakService {

  private final Keycloak keycloak;

  private final KeycloakUserDTOToUserRepresentationConverter keycloakUserDTOToUserRepresentationConverter;

  private final KeycloakConfigProperties keycloakConfigProperties;

  public Response createUser(KeycloakUserDTO userDTO) {
    UserRepresentation userRepresentation =
        keycloakUserDTOToUserRepresentationConverter.convert(userDTO);
    addCredentials(userRepresentation, userDTO.getPassword());
    return keycloak.realm(keycloakConfigProperties.getRealm()).users().create(userRepresentation);
  }

  public void updateUser(KeycloakUserDTO userDTO, String userId) {
    UserResource userResource =
        keycloak.realm(keycloakConfigProperties.getRealm()).users().get(userId);
    UserRepresentation user = userResource.toRepresentation();
    user.setFirstName(userDTO.getFirstname());
    user.setLastName(userDTO.getLastname());
    if(!ObjectUtils.isEmpty(userDTO.getUsername())) {
      user.setUsername(userDTO.getUsername());
    }
    userResource.update(user);
  }

  public Response removeUser(String userId) {
    return keycloak.realm(keycloakConfigProperties.getRealm()).users().delete(userId);
  }

  public void updateCredentials(String userId, String password) {
    UserResource userResource =
        keycloak.realm(keycloakConfigProperties.getRealm()).users().get(userId);
    UserRepresentation user = userResource.toRepresentation();
    addCredentials(user, password);
    userResource.update(user);
  }


  private void addCredentials(UserRepresentation userRepresentation, String password) {
    CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
    credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
    credentialRepresentation.setValue(password);
    userRepresentation.setCredentials(Arrays.asList(credentialRepresentation));
  }

}
