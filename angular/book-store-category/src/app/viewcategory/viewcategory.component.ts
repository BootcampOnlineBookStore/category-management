import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../category.service';
import { Category } from '../category';

@Component({
  selector: 'app-viewcategory',
  templateUrl: './viewcategory.component.html',
  styleUrls: ['./viewcategory.component.css']
})
export class ViewcategoryComponent implements OnInit {

  category : Category = null;
  observable : Observable<Category []> = null;

  constructor(private route: ActivatedRoute, private service : CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.reload();
  }
  reload() {
   return this.observable = this.service.viewAllCategories();
  }
  delete(id : number)
  {
    alert("Do you want to delete "+ id);
    this.service.deleteCategory(id).subscribe(data=>{console.log(data),error=>console.log(error),this.reload()});
  }

  update(category : Category){
    this.router.navigate(['/update',category.categoryId, category.categoryName]);
  } 

  books(id : number){
    this.router.navigate(['/books',id]);
  }


}
