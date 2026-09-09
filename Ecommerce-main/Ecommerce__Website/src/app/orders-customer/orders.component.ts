import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../order-details';
import { OrderDetailsServiceService } from '../order-details-service.service';
import { Router } from '@angular/router';
import { Orders } from '../orders';
import { OrdersListComponent } from '../orders-list/orders-list.component';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit{
  customerId!:number;

  orderss: OrderDetails[] | undefined;
  

  constructor(private orderService: OrderDetailsServiceService,private router:Router) { }

  ngOnInit(): void {
    this.getOrdersByCustomerId(this.customerId);
  }
 

  // getOrdersByCustomerId(): void {
  //   this.orderService.getOrdersByCustomerId(this.customerId).subscribe(orders =>
  //     {this.orders=orders}); 
  //}
  // getOrdersByCustomerId(customerId:number)
  // {
  //   this.orderService.getOrdersByCustomerId(this.customerId).subscribe(data=>
  //     {
  //       //this.orders=data;
  //       //console.log(data);
  //       this.getOrdersByCustomerId(this.customerId);
  //       this.orderss;
  //       console.log(data);

        
  //       },
  //       error=>console.log(error));
  //       this.getOrdersByCustomerId(this.customerId);

  //     }
  getOrdersByCustomerId(customerId:number)
  {
    this.orderService.getOrdersByCustomerId(customerId).subscribe(data=>{
      this.orderss=data;
      this.onSubmit();
    })
  }

  onSubmit(){
    //this.router.navigate(['displayByTitle',this.title]);
  }

    }


