import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherIngredientComponent } from './afficher-ingredient.component';

describe('AfficherIngredientComponent', () => {
  let component: AfficherIngredientComponent;
  let fixture: ComponentFixture<AfficherIngredientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AfficherIngredientComponent]
    });
    fixture = TestBed.createComponent(AfficherIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
