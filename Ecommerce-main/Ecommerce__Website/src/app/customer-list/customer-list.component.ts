import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit{
  customers:Customer[] | undefined;
  constructor(private customerService:CustomerServiceService, private route:Router){}

  ngOnInit(): void {
    this.getAllCustomer();
  }

  private getAllCustomer()
  {
    this.customerService.getCustomerList().subscribe(data=>
      {this.customers=data});
  }
  updateCustomer(customerId:number)
{
this.route.navigate(['update-customer',customerId]);
}

deleteCustomer(customerId:any)
{
  this.customerService.deletecustomerById(customerId).subscribe(data=>{
    //console.log(data);
    alert("Record got deleted!");
    this.getAllCustomer();
    //this.route.navigate(['/users']);

  },
  error=>{console.log(error)
  this.getAllCustomer();
});
}
}
