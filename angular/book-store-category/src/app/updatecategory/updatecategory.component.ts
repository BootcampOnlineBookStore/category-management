import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../category';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-updatecategory',
  templateUrl: './updatecategory.component.html',
  styleUrls: ['./updatecategory.component.css']
})
export class UpdatecategoryComponent implements OnInit {

  category : Category = new Category();
  constructor(private service : CategoryService, private route :ActivatedRoute, private router :Router) { }

  ngOnInit(): void {
    this.category.categoryId = Number(this.route.snapshot.paramMap.get("cid"));
    this.category.categoryName = this.route.snapshot.paramMap.get("cname");
  }
  update(){
    this.service.updateCategory(this.category).subscribe(data =>{ alert('updated');this.category=data } );
    this.router.navigate(['/view'])
  }

}
