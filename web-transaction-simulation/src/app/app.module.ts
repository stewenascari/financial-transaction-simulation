
import { HttpClientModule, provideHttpClient } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routes';
// Needs to import the BrowserAnimationsModule
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { URL } from '../environments/environment';
import { AppComponent } from './app.component';
import { CustomerRegistrationComponent } from './components/customer-registration/customer-registration.component';
import { StatementComponent } from './components/statement/statement.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { ClientService } from './services/client/client.service';
import { TransactionSimulationService } from './services/transaction/transaction-simulation.service';

// Importações do Angular Material
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { TransactionDialogComponent } from './components/transaction-dialog/transaction-dialog.component';

@NgModule({
  declarations: [
    TransactionsComponent,
    StatementComponent,
    HomeComponent,
    LoginComponent,
    TransactionDialogComponent,
    CustomerRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatSelectModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    MatTableModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  providers: [
    TransactionSimulationService,{provide: 'API_BASE_URL', useValue: URL.API_URL},
    ClientService,{provide: 'API_BASE_URL', useValue: URL.API_URL},
    provideHttpClient(),
    provideAnimationsAsync(),
    provideAnimationsAsync('noop')// Adicione withFetch() aqui
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
