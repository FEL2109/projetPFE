import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardEmployeComponent} from "./ui/employe/dashboard-employe/dashboard-employe.component";
import {DashboardManagerComponent} from "./ui/manager/dashboard-manager/dashboard-manager.component";
import {DashboardRhComponent} from "./ui/rh/dashboard-rh/dashboard-rh.component";
import {AuthGuard} from "./guards/auth.guard";
import {RoleGuard} from "./guards/role.guard";
import {UnauthorizedComponent} from "./ui/unauthorized/unauthorized.component";
import {RedirectByRoleComponent} from "./redirect-by-role/redirect-by-role.component";

const routes: Routes = [
  { path: '', redirectTo: 'redirect-by-role', pathMatch: 'full' },
  {
    path: 'employe',
    component: DashboardEmployeComponent,
    canActivate: [RoleGuard],
    data: { roles: ['USER'] }
  },
  {
    path: 'manager',
    component: DashboardManagerComponent,
    canActivate: [RoleGuard],
    data: { roles: ['ADMIN'] }
  },
  {
    path: 'rh',
    component: DashboardRhComponent,
    canActivate: [RoleGuard],
    data: { roles: ['RH'] }
  },
  {
    path: 'unauthorized',
    component: UnauthorizedComponent
  },
  {
    path: 'redirect-by-role',
    canActivate: [AuthGuard],
    component: RedirectByRoleComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
