import { Component, OnInit } from '@angular/core';
import { OrderDetailsServiceService } from '../order-details-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancel-order',
  templateUrl: './cancel-order.component.html',
  styleUrls: ['./cancel-order.component.css']
})
export class CancelOrderComponent implements OnInit {

  orderId!: number ;
  //message!: String;

  constructor(private orderDetailsService: OrderDetailsServiceService,private router:Router) { }

  ngOnInit() {
    this.orderId;
    //this.message ="Your Order is Cancelled";
  }

  cancelProduct() {
    if (this.orderId) {
      this.orderDetailsService.cancelProduct(this.orderId)
        .subscribe((result) => {
          //this.message = result;
          this.goToOrderList()
        });
    }
  }
  goToOrderList()
  {
   this.router.navigate(['/orders-list'])
  }
  onSubmit(){
    this.cancelProduct();
    this.goToOrderList();

  }

}
