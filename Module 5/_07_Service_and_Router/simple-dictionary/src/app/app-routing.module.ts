import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DictionaryPageComponent} from "./dictionary/dictionary-page/dictionary-page.component";
import {DictionaryDetailComponent} from "./dictionary/dictionary-detail/dictionary-detail.component";

const routes: Routes = [{
  path: 'dictionary/list',
  component: DictionaryPageComponent
}, {
  path: 'dictionary/detail/:id',
  component: DictionaryDetailComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
