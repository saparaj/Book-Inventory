package com.scanbuy.springservice.controller;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.scanbuy.springservice.dao.BookService;
import com.scanbuy.springservice.domain.Book;


@RestController
@RequestMapping("/service/book/")
public class SpringServiceController {
	

 BookService bookService=new BookService();
 
           
 @RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
 public Book getBook(@PathVariable int id) {
  Book book=bookService.getBookById(id);
  return book;
 }
 
 @RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
 public List<Book> getAllBooks() {
  List<Book> books=bookService.getAllBooks();
  return books;
 }
 
 @RequestMapping(value = "insert/{code}/{title}/{author}/{noofpages}/{havread}", method = RequestMethod.GET,headers="Accept=application/json")
 public List<Book> insert(@PathVariable("code") int barcode,@PathVariable("title") String title,@PathVariable("author") String author,@PathVariable("noofpages") int noofpages,@PathVariable("havread") boolean haveread)
 {
	 bookService.insert(barcode,title,author,noofpages,haveread);
	 List<Book> books=bookService.getAllBooks();
	  return books;
 }
 
 @RequestMapping(value = "delete/{id}", method = RequestMethod.GET,headers="Accept=application/json")
 public Book getDeletedBook(@PathVariable int id) {
	  Book book=bookService.getBookById(id);
	  bookService.delete(id);
	  return book;
	 }
 
 
 }
 
 
 

