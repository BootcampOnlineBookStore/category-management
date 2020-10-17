import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit {

  category : Category = new Category();
  temp : Category = new Category();
  constructor(private route: ActivatedRoute,private service : CategoryService, private router : Router) { }

  ngOnInit(): void {
  }
  createCategory(){
    console.log(this.category);
    this.service.createCategory(this.category).subscribe(data=>this.temp=data,error=>alert(error.error.errorMessage));
    alert("Category Added Succesfully");
    this.router.navigate(['view']);
  }

}
