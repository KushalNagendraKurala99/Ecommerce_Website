import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../order-details';
import { OrderDetailsServiceService } from '../order-details-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.css']
})
export class OrdersListComponent implements OnInit{
  orders:OrderDetails[] | undefined;
  constructor(private orderdetailService:OrderDetailsServiceService, private route:Router){}

  ngOnInit(): void {
    this.getAllOrders();
  }

  getAllOrders()
  {
    this.orderdetailService.getAllOrders().subscribe(data=>
      {this.orders=data});
  }

  
}
