import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Subject, takeUntil } from 'rxjs';
import { TransactionSimulationService } from '../../services/transaction/transaction-simulation.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  private unSubscribe = new Subject<Boolean>();
  public form: FormGroup = new FormGroup({});

  constructor(
    private bankService: TransactionSimulationService,
    private fb: FormBuilder
    ) {}

  ngOnInit(): void {
    this.initForm();
    }

  onSubmit() {
    this.bankService.insertTransaction(this.form)
    .pipe(takeUntil(this.unSubscribe))
    .subscribe();
  }

  initForm(): void {
    this.form = this.fb.group({
      tipo: '',
      valor: 0,
      email: '',
      numero_conta: '',
      saldo: 0

    })
  }
}
