import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
<<<<<<< HEAD
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CreateDateslotComponent } from './create-dateslot/create-dateslot.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDateAssignmentComponent } from './product-date-assignment/product-date-assignment.component';
import { ProductDateslotRelationComponent } from './product-dateslot-relation/product-dateslot-relation.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { OrdersComponent } from './orders-customer/orders.component';
import { OrdersListComponent } from './orders-list/orders-list.component';
import { CancelOrderComponent } from './cancel-order/cancel-order.component';
import { UpdateProductComponent } from './update-product/update-product.component';




@NgModule({
  declarations: [
    AppComponent,
    CreateDateslotComponent,
    CreateProductComponent,
    CreateCustomerComponent,
    SearchProductComponent,
    ProductListComponent,
    ProductDateAssignmentComponent,
    ProductDateslotRelationComponent,
    UpdateCustomerComponent,
    CustomerListComponent,
    OrderDetailsComponent,
    OrdersComponent,
    OrdersListComponent,
    CancelOrderComponent,
    UpdateProductComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
=======

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
>>>>>>> 4eae404 (initial commit)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
