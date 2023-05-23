import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionFormComponent } from './layouts/connexion-form/connexion-form.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { InscriptionFormComponent } from './layouts/inscription-form/inscription-form.component';
import { HomeComponent } from './pages/home/home.component';
import { FormulaireIngredientsComponent } from './layouts/formulaire-ingredients/formulaire-ingredients.component';
import { DescriptionComponent } from './components/description/description.component';
import { AfficherIngredientComponent } from './layouts/afficher-ingredient/afficher-ingredient.component';
import { FiltreRecettesComponent } from './layouts/filtre-recettes/filtre-recettes.component';
import { TableauRecettesComponent } from './layouts/tableau-recettes/tableau-recettes.component';
import { RecettesComponent } from './pages/recettes/recettes.component';
import { GestionCompteFormComponent } from './layouts/gestion-compte-form/gestion-compte-form.component';
import { ModifMdpFormComponent } from './layouts/modif-mdp-form/modif-mdp-form.component';
import { UpdateQuantIngredientComponent } from './layouts/update-quant-ingredient/update-quant-ingredient.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionFormComponent,
    FooterComponent,
    HeaderComponent,
    NavbarComponent,
    InscriptionFormComponent,
    HomeComponent,
    DescriptionComponent,
    FormulaireIngredientsComponent,
    AfficherIngredientComponent,
    FiltreRecettesComponent,
    TableauRecettesComponent,
    RecettesComponent,
    GestionCompteFormComponent,
    ModifMdpFormComponent,
    UpdateQuantIngredientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
