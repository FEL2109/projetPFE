import {CanActivateFn, Router} from '@angular/router';
import {inject} from '@angular/core';
import {KeycloakService} from "../services/keycloak/keycloak.service";

export const AuthGuard: CanActivateFn = () => {
  const keycloakService: KeycloakService = inject(KeycloakService);
  const router = inject(Router);

  if (keycloakService.keycloak.isTokenExpired()) {
    router.navigate(['login']);
    return false;
  }
  return true;
};

