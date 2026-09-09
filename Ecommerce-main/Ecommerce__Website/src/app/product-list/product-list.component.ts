import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { RouteReuseStrategy, Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  products:Product[] | undefined;
  constructor(private productService:ProductServiceService,private route:Router) {
    
  }
  ngOnInit(): void {
    this.getAllProducts();
    
  }

  private getAllProducts()
  {
    this.productService.getProductList().subscribe(data=>
      {this.products=data});
  }

  updateProduct(productId:number){
    this.route.navigate(['update-product',productId]);

  }

  deleteProduct(productId:number)
  {
    this.productService.deleteProductByProductId(productId).subscribe(data=>{
      //console.log(data);
      alert("Record got deleted!");
      this.getAllProducts();
      //this.route.navigate(['/users']);
  
    },
    error=>{console.log(error)
    this.getAllProducts();
  });
  }

  }

