import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RedirectByRoleComponent } from './redirect-by-role.component';

describe('RedirectByRoleComponent', () => {
  let component: RedirectByRoleComponent;
  let fixture: ComponentFixture<RedirectByRoleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RedirectByRoleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RedirectByRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
