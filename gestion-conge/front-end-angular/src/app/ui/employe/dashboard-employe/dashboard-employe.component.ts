import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "../../../services/keycloak/keycloak.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-dashboard-employe',
  templateUrl: './dashboard-employe.component.html',
  styleUrls: ['./dashboard-employe.component.css']
})
export class DashboardEmployeComponent implements OnInit{
  userRoles: string[] = [];
  public employe : any;
  constructor(
    private keycloakService: KeycloakService,
    private http: HttpClient) {}

  ngOnInit(): void {
    this.userRoles = this.keycloakService.getRoles();
    if (this.userRoles.includes('USER')) {
      this.http.get("http://localhost:8080/api/employes").subscribe({
        next : data => {
          this.employe = data;
        },
        error : err =>
        console.log(err)}
      )
    } else {

    }
  }
}


