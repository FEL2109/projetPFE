import {ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot} from '@angular/router';
import {KeycloakService} from "../services/keycloak/keycloak.service";
import {inject} from "@angular/core";

export const RoleGuard: CanActivateFn = (route) => {
  const keycloakService = inject(KeycloakService);
  const router = inject(Router);

  const requiredRoles = route.data['roles'] || [];
  const userRoles = keycloakService.getRoles();

  const hasAccess = requiredRoles.some((role: string) => userRoles.includes(role));

  if (!hasAccess) {
    router.navigate(['/unauthorized']);
    return false;
  }

  return true;
};
