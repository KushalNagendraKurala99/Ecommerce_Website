import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit{
  customer:Customer=new Customer();
id!:number;
  constructor(private customerService:CustomerServiceService, private router:ActivatedRoute, private route:Router) { }

  ngOnInit(): void {
    this.id=this.router.snapshot.params['id'];
    this.customerService.getCustomerByCustomerId(this.id).subscribe(data=>
      {
        this.customer=data;
      },
      error=>console.log(error));
  }

  onSubmit(){
    this.customerService.updateCustomer(this.id, this.customer).subscribe(data=>
      {
        this.goToCustomerList();

      },
      error=>console.log(error));

  }

  goToCustomerList()
  {
this.route.navigate(['/customers'])
  }

}