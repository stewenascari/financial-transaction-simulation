import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { ClienteModel } from '../../model/Client.model';
import { ClientService } from '../../services/client/client.service';
import { TransactionDialogComponent } from '../transaction-dialog/transaction-dialog.component';

@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html',
  styleUrls: ['./statement.component.css']
})
export class StatementComponent {
  private unSubscribe = new Subject<Boolean>();

  displayedColumns: string[] = ['descricao', 'valor', 'tipo', 'data'];
  dataSource = new MatTableDataSource([{}])
  saldo = 0
  conta = ""

  constructor(
    private clientService: ClientService,
    private fb: FormBuilder,
    private router: Router,
    public dialog: MatDialog
    ) { }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit(): void {
    this.getTransaction()
}


  saldoTotal: number = this.calculateTotal();

  calculateTotal(): number {
    return 0 }

  logout() {
    localStorage.removeItem('userId');
    this.router.navigate(["/inicio"])
    // Adicione aqui a lógica para o logout
    console.log('Logout realizado');
  }

  getTransaction(){
    var idClient = localStorage.getItem('userId')
    if(idClient){
      this.clientService.getClient(Number(idClient))
      .pipe(takeUntil(this.unSubscribe))
      .subscribe(
        (cliente: ClienteModel) => {
          if (cliente && cliente.transacoes) {
            this.conta = cliente.numero_conta?cliente.numero_conta: ""
            this.saldo = cliente.saldo? cliente.saldo: 0
            this.dataSource = new MatTableDataSource(cliente.transacoes)
          }
        }
      );
    }

  }


  openDialog(): void {
    const dialogRef = this.dialog.open(TransactionDialogComponent, {
      height: '600px',
      width: '900px',
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.saldo = result.saldo_atualizado;
        this.dataSource.data = [...this.dataSource.data, result];
      }
    });
  }
}
