import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FormulaireIngredientsComponent } from './layouts/formulaire-ingredients/formulaire-ingredients.component';
import { InscriptionFormComponent } from './layouts/inscription-form/inscription-form.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'formulaireIngredient', component: FormulaireIngredientsComponent},
  {path: 'inscription', component: InscriptionFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
