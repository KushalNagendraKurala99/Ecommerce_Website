import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit{
  product:Product=new Product();
  id!:number;
    constructor(private productService:ProductServiceService, private router:ActivatedRoute, private route:Router) { }
  
    ngOnInit(): void {
      this.id=this.router.snapshot.params['id'];
      this.productService.getProductByProductId(this.id).subscribe(data=>
        {
          this.product=data;
        },
        error=>console.log(error));
    }
  
    onSubmit(){
      this.productService.updateProduct(this.id, this.product).subscribe(data=>
        {
          this.goToProductList();
  
        },
        error=>console.log(error));
  
    }
  
    goToProductList()
    {
  this.route.navigate(['/product-list'])
    }
}
  


