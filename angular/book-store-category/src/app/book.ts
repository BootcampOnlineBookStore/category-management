import { Category } from "./category";

export class Book{
    bookId : number;
    bookTitle : string;
    bookAuthor : string;
    bookPrice : number;
    bookISBN : string;
    category : Category = new Category();
}