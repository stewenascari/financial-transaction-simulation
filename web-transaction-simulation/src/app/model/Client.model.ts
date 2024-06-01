import { TransactionModel } from "./Transaction.model"

export class ClienteModel {
  public id?: number
  public nome?: string
  public email?: string
  public idade?: number
  public numero_conta?: string
  public saldo?: number
  public transacoes?: TransactionModel[]
}
