import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {AuthenticationService} from './services/authentication.service';
import {DashboardComponent} from './secure/dashboard/dashboard.component';
import {AuthGuard} from './services/auth.guard';
import {ROUTING} from './app.routes';
import {Ng2Webstorage} from 'ngx-webstorage';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    ROUTING,
    Ng2Webstorage.forRoot({prefix: 'ouath', separator: '-'}),
  ],
  providers: [
    AuthenticationService,
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
