import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveStatutComponent } from './leave-statut.component';

describe('LeaveStatutComponent', () => {
  let component: LeaveStatutComponent;
  let fixture: ComponentFixture<LeaveStatutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaveStatutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaveStatutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
