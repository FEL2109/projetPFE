import { Component, OnInit } from '@angular/core';
import { KeycloakService } from './services/keycloak/keycloak.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isKeycloakInitialized = false;

  constructor(private keycloakService: KeycloakService) {}

  async ngOnInit() {
    this.isKeycloakInitialized = await this.keycloakService.init();
    if (!this.isKeycloakInitialized) {
      console.error('Keycloak failed to initialize');

    }
  }
}
