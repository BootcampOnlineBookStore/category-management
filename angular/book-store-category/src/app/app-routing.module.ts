import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddcategoryComponent } from './addcategory/addcategory.component';
import { BookbycategoryComponent } from './bookbycategory/bookbycategory.component';
import { UpdatecategoryComponent } from './updatecategory/updatecategory.component';
import { ViewcategoryComponent } from './viewcategory/viewcategory.component';


const routes: Routes = [
  {
    path : 'view',
    component : ViewcategoryComponent,
    
  },
  {
    path : 'add',
    component : AddcategoryComponent,
    
  },
  {
    path : 'update/:cid/:cname',
    component : UpdatecategoryComponent,
    
  },
  {
    path : 'books/:cid',
    component : BookbycategoryComponent,
  },
  {
    path : '',
    redirectTo : '/view',
    pathMatch : 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
