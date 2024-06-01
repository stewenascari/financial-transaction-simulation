import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Subject, takeUntil } from 'rxjs';
import { TransactionModel } from '../../model/Transaction.model';
import { TransactionSimulationService } from '../../services/transaction/transaction-simulation.service';

@Component({
  selector: 'app-transaction-dialog',
  templateUrl: './transaction-dialog.component.html',
  styleUrl: './transaction-dialog.component.css'
})
export class TransactionDialogComponent {
  public form: FormGroup = new FormGroup({});
  private unSubscribe = new Subject<Boolean>();

  constructor(
    public dialogRef: MatDialogRef<TransactionDialogComponent>,
    private fb: FormBuilder,
    private translateService: TransactionSimulationService,
    ) {}

  ngOnInit(): void {
          this.initForm();
      }

  onSave(): void {
    this.translateService.insertTransaction(this.form.getRawValue())
    .pipe(takeUntil(this.unSubscribe))
    .subscribe(
      (transaction: TransactionModel) => {
        if (transaction) {
          this.dialogRef.close(transaction);
        }
      }
    );
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  initForm(): void {
    this.form = this.fb.group({
      "id_cliente": Number(localStorage.getItem('userId')),
      "descricao": '',
      "valor": 0,
      "tipo": '',
      "data": null

    })
  }
}
