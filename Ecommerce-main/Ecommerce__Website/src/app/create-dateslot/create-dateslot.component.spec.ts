import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDateslotComponent } from './create-dateslot.component';

describe('CreateDateslotComponent', () => {
  let component: CreateDateslotComponent;
  let fixture: ComponentFixture<CreateDateslotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDateslotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateDateslotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
