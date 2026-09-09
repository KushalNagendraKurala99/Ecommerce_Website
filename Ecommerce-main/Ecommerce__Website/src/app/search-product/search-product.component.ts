import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { DateSlot } from '../date-slot';
import { ProductServiceService } from '../product-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit{
  products:Product[] | undefined;
  category!:string;
  productName!:string;
  
  
  dateslots:DateSlot=new DateSlot();
    constructor(private productService:ProductServiceService,private router:Router){}
  
    ngOnInit(): void {
    }
    orderProduct(){
  
    }
    // displayTimeslot(train:any){
    //   train.forEach((time:any)=>{
    //     this.timeslots=time.timeSlot;
    //   })
    // }
  
    searchProduct(category: string)
    {
      this.productService.searchProduct(this.category).subscribe(data=>
        {
          this.products=data;
          console.log(data);
  
          this.products.forEach((date:any)=>{
            this.dateslots=date.dateSlot;
          });
  
        },
        error=>console.log(error));
    }

   
  
    goToOrderedTrain()
    {
      
    }
  
    // onSubmit(){
  
    // }
  
  
  }
  