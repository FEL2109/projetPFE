import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeBalanceComponent } from './employee-balance.component';

describe('EmployeeBalanceComponent', () => {
  let component: EmployeeBalanceComponent;
  let fixture: ComponentFixture<EmployeeBalanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeBalanceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeeBalanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
