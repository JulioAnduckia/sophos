import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteAComponent } from './delete-a.component';

describe('DeleteAComponent', () => {
  let component: DeleteAComponent;
  let fixture: ComponentFixture<DeleteAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteAComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
