import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FormulaireIngredientsComponent } from './layouts/formulaire-ingredients/formulaire-ingredients.component';
import { InscriptionFormComponent } from './layouts/inscription-form/inscription-form.component';
import { RecettesComponent } from './pages/recettes/recettes.component';
import { IngredientsComponent } from './pages/ingredients/ingredients.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';
import { ModifierIngredientComponent } from './pages/modifier-ingredient/modifier-ingredient.component';
import { GestionCompteComponent } from './pages/gestion-compte/gestion-compte.component';
import { ModifierMdpComponent } from './pages/modifier-mdp/modifier-mdp.component';

const routes: Routes = [
  {path: 'ingredient', component: IngredientsComponent},
  {path: 'inscription', component: InscriptionComponent},
  {path: 'recette', component: RecettesComponent},
  {path: 'modifieringredient', component: ModifierIngredientComponent},
  {path: 'gestioncompte', component: GestionCompteComponent},
  {path: 'modifiermdp', component: ModifierMdpComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
