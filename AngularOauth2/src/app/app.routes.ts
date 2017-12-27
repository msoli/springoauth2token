import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {DashboardComponent} from './secure/dashboard/dashboard.component';
import {AuthGuard} from './services/auth.guard';


export const ROUTES: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: '**', pathMatch: 'full', redirectTo: 'login'},
];

export const ROUTING = RouterModule.forRoot(ROUTES);

