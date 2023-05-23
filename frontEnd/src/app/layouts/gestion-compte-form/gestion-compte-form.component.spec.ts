import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionCompteFormComponent } from './gestion-compte-form.component';

describe('GestionCompteFormComponent', () => {
  let component: GestionCompteFormComponent;
  let fixture: ComponentFixture<GestionCompteFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GestionCompteFormComponent]
    });
    fixture = TestBed.createComponent(GestionCompteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
