import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerRegistrationComponent } from './components/customer-registration/customer-registration.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { StatementComponent } from './components/statement/statement.component';
import { TransactionsComponent } from './components/transactions/transactions.component';

export const routes: Routes = [
  { path: 'cadastrar', component: CustomerRegistrationComponent },
  { path: 'transactions', component: TransactionsComponent },
  { path: 'transacoes', component: StatementComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inicio', component: HomeComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
