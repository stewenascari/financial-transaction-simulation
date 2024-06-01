import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL } from '../../../environments/environment';
import { ClienteModel } from '../../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl = `${URL.API_URL}/clientes`;

  constructor(private http: HttpClient) { }

  insertClient(client: ClienteModel): Observable<ClienteModel> {
    return this.http.post<ClienteModel>(`${this.baseUrl}`, client);
  }

  updateClient(clientId: number, client: Object): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${clientId}`, { client });
  }

  deleteClient(clientId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${clientId}`);
  }

  getClient(clientId: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/id/${clientId}`);
  }

  getClientByConta(emailClient: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${emailClient}`);
  }
}
