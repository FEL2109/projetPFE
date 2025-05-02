import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {KeycloakService} from "../services/keycloak/keycloak.service";

@Component({
  selector: 'app-redirect-by-role',
  templateUrl: './redirect-by-role.component.html',
  styleUrls: ['./redirect-by-role.component.css']
})
export class RedirectByRoleComponent implements OnInit {

  constructor(
    private router: Router,
    private keycloakService: KeycloakService
  ) {}

  ngOnInit(): void {
    const keycloakInstance = this.keycloakService.keycloak;

    if (keycloakInstance) {
      console.log('[Keycloak] Token JWT :', keycloakInstance.token);
      console.log('[Keycloak] Realm Roles :', keycloakInstance.tokenParsed?.realm_access?.roles);
      console.log('[Keycloak] Resource Access :', keycloakInstance.tokenParsed?.resource_access);
    } else {
      console.error('Keycloak n’est pas encore initialisé.');
    }
  }
}



















