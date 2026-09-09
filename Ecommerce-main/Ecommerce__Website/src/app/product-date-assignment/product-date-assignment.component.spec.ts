import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDateAssignmentComponent } from './product-date-assignment.component';

describe('ProductDateAssignmentComponent', () => {
  let component: ProductDateAssignmentComponent;
  let fixture: ComponentFixture<ProductDateAssignmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductDateAssignmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductDateAssignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
