import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MedicalListComponent} from "./medical-list/medical-list.component";
import {MedicalUpdateComponent} from "./medical-update/medical-update.component";

const routes: Routes = [{
  path: "list",
  component: MedicalListComponent
}, {
  path: "update/:id",
  component: MedicalUpdateComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MedicalRoutingModule { }
