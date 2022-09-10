import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmailformComponent } from './components/emailform/emailform.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path: 'sendmail',
    component:EmailformComponent,
    pathMatch:"full"
  },
  {
    path:'',
    component:HomeComponent,
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
