import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateQuantIngredientComponent } from './update-quant-ingredient.component';

describe('UpdateQuantIngredientComponent', () => {
  let component: UpdateQuantIngredientComponent;
  let fixture: ComponentFixture<UpdateQuantIngredientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateQuantIngredientComponent]
    });
    fixture = TestBed.createComponent(UpdateQuantIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
