import { TestBed } from '@angular/core/testing';

import { ServiceAccountsService } from './service-accounts.service';

describe('ServiceAccountsService', () => {
  let service: ServiceAccountsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceAccountsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
