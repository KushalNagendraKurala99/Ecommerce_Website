import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CreateDateslotComponent } from './create-dateslot/create-dateslot.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDateAssignmentComponent } from './product-date-assignment/product-date-assignment.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { OrdersComponent } from './orders-customer/orders.component';
import { OrdersListComponent } from './orders-list/orders-list.component';
import { CancelOrderComponent } from './cancel-order/cancel-order.component';
import { UpdateProductComponent } from './update-product/update-product.component';



const routes: Routes = [
  {path:'create-customer',component:CreateCustomerComponent},
  {path:'customers',component:CustomerListComponent},
  {path:'update-customer/:id',component:UpdateCustomerComponent},
  {path:'create-dateslot',component:CreateDateslotComponent},
  {path:'create-product',component:CreateProductComponent},
  {path:'products',component:ProductListComponent},
  {path:'assignment',component:ProductDateAssignmentComponent},
  {path:'search-product',component:SearchProductComponent},
  {path:'order-details',component:OrderDetailsComponent},
  {path:'orders',component:OrdersComponent},
  {path:'orders-list',component:OrdersListComponent},
  {path:'cancel-order',component:CancelOrderComponent},
  {path:'update-product/:id',component:UpdateProductComponent},
  
  
];
=======

const routes: Routes = [];
>>>>>>> 4eae404 (initial commit)

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
