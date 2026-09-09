import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDateslotRelationComponent } from './product-dateslot-relation.component';

describe('ProductDateslotRelationComponent', () => {
  let component: ProductDateslotRelationComponent;
  let fixture: ComponentFixture<ProductDateslotRelationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductDateslotRelationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductDateslotRelationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
