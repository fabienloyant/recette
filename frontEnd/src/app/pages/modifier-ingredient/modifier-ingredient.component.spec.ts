import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierIngredientComponent } from './modifier-ingredient.component';

describe('ModifierIngredientComponent', () => {
  let component: ModifierIngredientComponent;
  let fixture: ComponentFixture<ModifierIngredientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifierIngredientComponent]
    });
    fixture = TestBed.createComponent(ModifierIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
