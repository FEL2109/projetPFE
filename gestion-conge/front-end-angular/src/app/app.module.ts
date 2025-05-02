import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { FormsModule } from '@angular/forms';
import {ToastrModule} from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {KeycloakService} from "./services/keycloak/keycloak.service";
import {SidebarComponent} from "./ui/shared/sidebar/sidebar.component";
import { LoginComponentComponent } from './ui/shared/login-component/login-component.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HttpTokenInterceptor} from "./interceptors/http-token.interceptor";
import { UnauthorizedComponent } from './ui/unauthorized/unauthorized.component';
import { RedirectByRoleComponent } from './redirect-by-role/redirect-by-role.component';
import {DashboardEmployeComponent} from "./ui/employe/dashboard-employe/dashboard-employe.component";
import {DashboardManagerComponent} from "./ui/manager/dashboard-manager/dashboard-manager.component";
import {DashboardRhComponent} from "./ui/rh/dashboard-rh/dashboard-rh.component";

export function initializeKeycloak(keycloak: KeycloakService){
  return () =>
    keycloak.init();
}

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    LoginComponentComponent,
    UnauthorizedComponent,
    RedirectByRoleComponent,
    DashboardEmployeComponent,
    DashboardManagerComponent,
    DashboardRhComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ToastrModule.forRoot({
      progressBar : true,
      closeButton : true,
      newestOnTop : true,
      tapToDismiss : true,
      positionClass : 'toast-bottom-right',
      timeOut :0,

    })
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US },
    { provide: HTTP_INTERCEPTORS,
      useClass: HttpTokenInterceptor,
      multi: true
    },
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
