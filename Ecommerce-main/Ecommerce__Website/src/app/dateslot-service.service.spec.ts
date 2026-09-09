import { TestBed } from '@angular/core/testing';

import { DateslotServiceService } from './dateslot-service.service';

describe('DateslotServiceService', () => {
  let service: DateslotServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DateslotServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
