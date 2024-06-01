import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { ClienteModel } from '../../model/Client.model';
import { ClientService } from '../../services/client/client.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
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
    this.clientService.getClientByConta(this.form.get("conta")?.value)
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
      "conta": ['', [Validators.required]]
    })
  }
}
