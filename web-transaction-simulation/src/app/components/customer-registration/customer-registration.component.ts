import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { ClienteModel } from '../../model/Client.model';
import { ClientService } from '../../services/client/client.service';

@Component({
  selector: 'app-customer-registration',
  templateUrl: './customer-registration.component.html',
  styleUrls: ['./customer-registration.component.css']
})
export class CustomerRegistrationComponent implements OnInit {
  private unSubscribe = new Subject<Boolean>();
  public form: FormGroup = new FormGroup({});

  constructor(
    private clientService: ClientService,
    private fb: FormBuilder,
    private router: Router
    ) { }

  ngOnInit(): void {
        this.initForm();
    }

  onSubmit(){
    this.clientService.insertClient(this.form.getRawValue())
    .pipe(takeUntil(this.unSubscribe))
    .subscribe(
      (cliente: ClienteModel) => {
        if (cliente && cliente.id) {
          localStorage.setItem('userId', cliente.id.toString());
          this.router.navigate(["/transacoes"])
        }
      }
    );
  }

  initForm(): void {
    this.form = this.fb.group({
      nome: '',
      email: '',
      numero_conta: '',
      idade: ['', [Validators.required, Validators.min(18)]],
      saldo: ['', [Validators.required, Validators.min(0)]],

    })
  }
}
