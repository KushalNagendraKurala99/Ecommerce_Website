import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { Params } from '@angular/router';
import { AssignmentProductDateslot } from './assignment-product-dateslot';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  
  private APIs="http://localhost:8082/api/";
  private assignment="http://localhost:8082/api/assignProductToDateslot";
  private searchProductUrl="http://localhost:8082/api/searchProduct";
  private searchProductByNameUrl="http://localhost:8082/api/searchProductByName";
  private updateproductUrl="http://localhost:8082/api/updateProduct";
  private deleteproductUrl="http://localhost:8082/api/deleteProduct";
  private getProuctByProductIdUrl="http://localhost:8082/api/getProductById";

  constructor(private httpClient:HttpClient) { }
  createProduct(product:Product):Observable<Object>
  {
    return this.httpClient.post(this.APIs+'createProduct',product);
  }

  getProductList():Observable<Product[]>
  {
    return this.httpClient.get<Product[]>(this.APIs+'getAllProduct');
  }

  assignmentProductToDateslot(productId:number,dateslot:number):Observable<Params>
  {
    return this.httpClient.post(`${this.assignment}/${productId}/${dateslot}`,AssignmentProductDateslot);
  }

  searchProduct(category:string):Observable<Product[]>
  {
    return this.httpClient.get<Product[]>(`${this.searchProductUrl}/${category}`);
  }

  updateProduct(id:number,product:Product):Observable<object>
  {
  return this.httpClient.put(`${this.updateproductUrl}/${id}`,product);
  }

  deleteProductByProductId(id:number):Observable<Object>
  {
    return this.httpClient.delete(`${this.deleteproductUrl}/${id}`);
  }

  getProductByProductId(id:number):Observable<Product>
  {
    return this.httpClient.get<Product>(`${this.getProuctByProductIdUrl}/${id}`);
  }


}
