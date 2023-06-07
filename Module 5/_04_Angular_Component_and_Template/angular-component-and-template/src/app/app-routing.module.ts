import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AngularTimelinesAppComponent} from './angular-timelines-app/angular-timelines-app.component';

const routes: Routes = [
  {
    path: 'timelines',
    component: AngularTimelinesAppComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
