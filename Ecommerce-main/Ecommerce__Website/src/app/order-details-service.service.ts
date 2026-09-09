import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderDetails } from './order-details';
import { Params } from '@angular/router';
import { Orders } from './orders';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsServiceService {
  private orderProductUrl="http://localhost:8082/orderProduct";
  private getOrdersById="http://localhost:8082/getOrdersByCustomerId";
  private getOrdersUrl="http://localhost:8082/getAllOrders";
  private cancelProductUrl="http://localhost:8082/cancelOrder";


  constructor(private httpClient:HttpClient) { }

  // orderProduct(productNo:number,customerId:number):Observable<Params>
  // {
  //   return this.httpClient.post<OrderDetails>(`${this.orderProductUrl}/${productNo}/${customerId}`,OrderDetails);
  // }

  orderProduct(productNo:number,customerId:number,orderDetail:OrderDetails):Observable<OrderDetails>
  {
    return this.httpClient.post<OrderDetails>(`${this.orderProductUrl}/${productNo}/${customerId}`,orderDetail);
  }

  cancelProduct(orderId:number):Observable<OrderDetails>
  {
    return this.httpClient.delete<OrderDetails>(`${this.cancelProductUrl}/${orderId}`);
  }

  getOrdersByCustomerId(customerId:number):Observable<OrderDetails[]>
  {
    return this.httpClient.get<OrderDetails[]>(`${this.getOrdersById}/${customerId}`);
  }

  getAllOrders():Observable<OrderDetails[]>
  {
    return this.httpClient.get<OrderDetails[]>(`${this.getOrdersUrl}`);
  }
}
