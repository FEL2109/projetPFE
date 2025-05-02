import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "../../../services/keycloak/keycloak.service";
import {AuthenticationRequest} from "../../../services/models/authentication-request";

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit{
  // authRequest: AuthenticationRequest = {email: '', password: ''};
  // errorMsg: Array<string> = [];

  constructor(
    private keycloakService: KeycloakService
  ) {
  }

  async ngOnInit(): Promise<void> {
    await this.keycloakService.init();
    await this.keycloakService.login();
  }
}
