import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL } from '../../../environments/environment';
import { TransactionModel } from '../../model/Transaction.model';
@Injectable({
  providedIn: 'root'
})
export class TransactionSimulationService {

  private baseUrl = `${URL.API_URL}/transacoes`;

  constructor(private http: HttpClient) { }

  insertTransaction(transaction: TransactionModel): Observable<TransactionModel> {
    return this.http.post<any>(`${this.baseUrl}`, transaction );
  }
}
