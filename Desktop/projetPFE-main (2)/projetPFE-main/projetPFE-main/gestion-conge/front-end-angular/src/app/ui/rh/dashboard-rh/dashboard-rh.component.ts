import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "../../../services/keycloak/keycloak.service";

@Component({
  selector: 'app-dashboard-rh',
  templateUrl: './dashboard-rh.component.html',
  styleUrls: ['./dashboard-rh.component.css']
})
export class DashboardRhComponent implements OnInit {
  userRoles: string[] = [];

  constructor(private keycloakService: KeycloakService) {
  }

  ngOnInit(): void {
    this.userRoles = this.keycloakService.getRoles();

    if (this.userRoles.includes('RH')) {

    } else {

    }
  }
}


