import { TestBed } from '@angular/core/testing';

import { OrderDetailsServiceService } from './order-details-service.service';

describe('OrderDetailsServiceService', () => {
  let service: OrderDetailsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderDetailsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
