import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Category } from '../category';
import { Book } from '../book';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-bookbycategory',
  templateUrl: './bookbycategory.component.html',
  styleUrls: ['./bookbycategory.component.css']
})
export class BookbycategoryComponent implements OnInit {

  categoryId : number;
  categoryName : string;
  category : Category = new Category();
  observable : Observable<Book []>=null;
  book : Book = new Book();
  books : Book[] = null;
  flag = true;

  constructor(private route:ActivatedRoute,private service: CategoryService, private router : Router) { }

  ngOnInit(): void {
    this.categoryId = Number(this.route.snapshot.paramMap.get("cid"));
    this.reload();
  }

  reload()
  {
    this.observable=this.service.viewBooks(this.categoryId);
    this.observable.subscribe(data=>{this.books=data},error=>{this.flag=false;alert("No books To Display")});
  }


}
