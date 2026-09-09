import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private createCustomerUrl="http://localhost:8082/api/createCustomer";
  private customerssList="http://localhost:8082/api/getAllCustomer";
  private updateCustomerUrl="http://localhost:8082/api/updateCustomer";
  private getCustomerById="http://localhost:8082/api/getCustomerById";
  private deleteCustomerUrl="http://localhost:8082/api/deletecustomer";
 
  

  constructor(private httpClient:HttpClient) { }

  createCustomer(customer:Customer):Observable<Object> {
    return this.httpClient.post(`${this.createCustomerUrl}`,customer);
  }

  getCustomerList():Observable<Customer[]>
  {
    return this.httpClient.get<Customer[]>(`${this.customerssList}`);
  }

  updateCustomer(id:number,customer:Customer):Observable<object>
  {
  return this.httpClient.put(`${this.updateCustomerUrl}/${id}`,customer);
  }

  getCustomerByCustomerId(id:number):Observable<Customer>
  {
    return this.httpClient.get<Customer>(`${this.getCustomerById}/${id}`);
  }

  deletecustomerById(id:number):Observable<Object>
  {
    return this.httpClient.delete(`${this.deleteCustomerUrl}/${id}`);
  }
}
