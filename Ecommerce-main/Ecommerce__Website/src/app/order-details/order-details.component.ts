import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../order-details';
import { OrderDetailsServiceService } from '../order-details-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit{
  orders:OrderDetails=new OrderDetails();
  productNo!:number;
  customerId!:number;

  constructor(private orderDetailService:OrderDetailsServiceService, private router:Router) {}

  // ngOnInit(): void {
    
  // }

  // onSubmit(){
  //   this.orderProduct();
  // }

  // orderProduct(){
  //   this.orderDetailService.orderProduct(this.productNo,this.customerId,this.orders).subscribe(data=>
  //     {console.log(data),
  //     this.goToOrderList();},
  //     error=>{console.log(error);
  //    this.goToOrderList() });
    
  // }

  // goToOrderList()
  // {
  //  // this.router.navigate(['/orders-list'])
  // }
  ngOnInit() {
    // initialize variables or get data from service here
    this.productNo;
    this.customerId;
    // this.orderDetails.quantity = 3;
    // this.orderDetails.address = "123 Main St";
  }

  onSubmit(){

  }

  orderProduct() {
    this.orderDetailService.orderProduct(this.productNo, this.customerId, this.orders)
      .subscribe((result) => {
        console.log(result);
        this.goToOrderList()
      });
  }

  goToOrderList()
  {
   this.router.navigate(['/orders-list'])
  }
}


  