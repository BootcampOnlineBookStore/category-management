import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from './category';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http : HttpClient) { }

  viewAllCategories() : Observable<Category []>{
    return this.http.get<Category []>("http://localhost:8080/category/view");
  }

  searchCategory(categoryId :number)  : Observable<Category>{
    return this.http.get<Category>("http://localhost:8080/category/search/"+categoryId);
  }

  createCategory(category : Category) : Observable<Category> {
    console.log("Service : "+category.categoryId);
    return this.http.post<Category>("http://localhost:8080/category/create",category);
  }

  deleteCategory(categoryId : number) : Observable<Category>{
    console.log(" Id = "+categoryId);
    return this.http.delete<Category>("http://localhost:8080/category/delete/"+categoryId);
  }

  updateCategory(category : Category) :Observable<Category>
  {
    return this.http.put<Category>("http://localhost:8080/category/update",category);
  }

  viewBooks(categoryId : number) : Observable<Book []>{
    return this.http.get<Book []>("http://localhost:8080/category/books/"+categoryId);
  }

}
