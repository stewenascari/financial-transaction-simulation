import { TestBed } from '@angular/core/testing';

import { TransactionSimulationService } from './transaction-simulation.service';

describe('TransactionSimulationService', () => {
  let service: TransactionSimulationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactionSimulationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
