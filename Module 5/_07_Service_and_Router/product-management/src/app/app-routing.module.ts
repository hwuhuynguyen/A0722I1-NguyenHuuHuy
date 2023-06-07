import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductListComponent} from "./product/product-list/product-list.component";
import {ProductCreateComponent} from "./product/product-create/product-create.component";
import {ProductUpdateComponent} from "./product/product-update/product-update.component";
import {ProductDeleteComponent} from "./product/product-delete/product-delete.component";

const routes: Routes = [{
  path: 'product/list',
  component: ProductListComponent
}, {
  path: 'product/create',
  component: ProductCreateComponent
}, {
  path: 'product/update/:id',
  component: ProductUpdateComponent
}, {
  path: 'product/delete/:id',
  component: ProductDeleteComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
