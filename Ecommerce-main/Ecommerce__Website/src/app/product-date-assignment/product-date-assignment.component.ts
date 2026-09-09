import { Component, OnInit } from '@angular/core';
import { AssignmentProductDateslot } from '../assignment-product-dateslot';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-product-date-assignment',
  templateUrl: './product-date-assignment.component.html',
  styleUrls: ['./product-date-assignment.component.css']
})
export class ProductDateAssignmentComponent implements OnInit {
  assignment:AssignmentProductDateslot=new AssignmentProductDateslot();
  message!:String;
  productId!:number;
  dateslotId!:number;
  isAssignment=false;


constructor(private productService:ProductServiceService) {}

ngOnInit(): void {

}

onSubmit() {
  this.productService.assignmentProductToDateslot(this.productId,this.dateslotId).subscribe(data=>
    {
      console.log(data);
      this.isAssignment=true;
      this.message="Timeslot is added successfully!! ";
    },
    error=>{console.log(error);
    this.isAssignment=true;});
  }
}
