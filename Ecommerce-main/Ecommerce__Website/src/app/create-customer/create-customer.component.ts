import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer:Customer=new Customer();
  constructor(private customerService:CustomerServiceService, private route:Router) {}

  ngOnInit(): void {
    
  }
  createCustomer(){
    this.customerService.createCustomer(this.customer).subscribe(data=>{
      console.log(data);
      this.goToCustomerList();
    },
    error=>console.log(error)
    
    
    );
  }

  goToCustomerList()
  {
this.route.navigate(['/customers'])
  }


   onSubmit(){
    this.createCustomer();
    //throw new Error('Method not implemented.');
   }

}
