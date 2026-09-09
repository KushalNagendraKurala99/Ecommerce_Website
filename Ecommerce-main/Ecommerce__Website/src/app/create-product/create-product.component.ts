import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit{
  product:Product=new Product();

  constructor(private productservice:ProductServiceService, private router:Router) {}

  ngOnInit(): void {
    
  }

  onSubmit(){
    this.createProduct();
  }

  createProduct(){
    this.productservice.createProduct(this.product).subscribe(data=>
      {console.log(data),
      this.goToProductList();},
      error=>{console.log(error);
     this.goToProductList() });
    
  }

  goToProductList()
  {
    this.router.navigate(['/products'])
  }

}
