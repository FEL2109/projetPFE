import { Injectable } from '@angular/core';
import Keycloak from "keycloak-js";
import {EmployeProfile} from "./employe-profile";

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {

  private _keycloak: Keycloak | undefined;
  private _profile: EmployeProfile | undefined;

  get keycloak() {
    if (!this._keycloak){
      this._keycloak=new Keycloak({
        url: 'http://localhost:8181',
        realm: 'gestion-conge-app',
        clientId: 'front-end-angular-client',
        });
    }
    return this._keycloak;
  }
  get profile(): EmployeProfile | undefined {
    return this._profile;
  }

  constructor() {}

  async init() {
    const authenticated = await this.keycloak.init({
      onLoad: 'login-required',
      checkLoginIframe: false,
      pkceMethod: 'S256',
    });

    if (authenticated) {
      this._profile = (await this.keycloak.loadUserProfile()) as EmployeProfile;
      this._profile.token = this.keycloak.token;
      return true;
    }
    return false;
  }

  login() {
    return this.keycloak.login();
  }

  logout() {
    return this.keycloak.accountManagement();
  }

  getRoles(): string[] {
    return this.keycloak.tokenParsed?.realm_access?.roles || [];
  }
}
