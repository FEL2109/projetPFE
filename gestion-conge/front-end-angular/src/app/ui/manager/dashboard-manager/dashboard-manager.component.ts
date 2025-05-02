import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "../../../services/keycloak/keycloak.service";

@Component({
  selector: 'app-dashboard-manager',
  templateUrl: './dashboard-manager.component.html',
  styleUrls: ['./dashboard-manager.component.css']
})
export class DashboardManagerComponent implements OnInit {
  userRoles: string[] = [];

  constructor(private keycloakService: KeycloakService) {
  }

  ngOnInit(): void {
    this.userRoles = this.keycloakService.getRoles();

    if (this.userRoles.includes('ADMIN')) {

    } else {

    }
  }
}
