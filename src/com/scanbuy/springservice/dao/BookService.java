package com.scanbuy.springservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.scanbuy.springservice.domain.Book;
import com.scanbuy.springservice.utility.DBUtility;

public class BookService {
 
 private Connection connection;

 public BookService() {
  connection = DBUtility.getConnection();
 }
  

 public List<Book> getAllBooks() {
  List<Book> bookList = new ArrayList<Book>();
  try {
   PreparedStatement preparedstatement = connection.prepareStatement("select * from books");
   ResultSet rs = preparedstatement.executeQuery();
   while (rs.next()) {
	   Book bookObj = new Book();
	   bookObj.setBarcode(rs.getInt("barcode"));
	   bookObj.setTitle(rs.getString("title"));
	   bookObj.setAuthor(rs.getString("author"));
	   bookObj.setNoofpages(rs.getInt("noofpages"));
	   bookObj.setHaveread(rs.getBoolean("haveread"));
	   bookList.add(bookObj);
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }

  return bookList;
 }
 
 public Book getBookById(int barcode) {
  Book bookObj = new Book();
  try {
   PreparedStatement preparedStatement = connection.prepareStatement("select * from books where barcode=?");
   preparedStatement.setInt(1, barcode);
   ResultSet rs = preparedStatement.executeQuery();
   
   if (rs.next()) {
	   bookObj.setBarcode(rs.getInt("barcode"));
		bookObj.setTitle(rs.getString("title"));
		bookObj.setAuthor(rs.getString("author"));
		bookObj.setNoofpages(rs.getInt("noofpages"));
		bookObj.setHaveread(rs.getBoolean("haveread"));
   }
  } catch (SQLException e) {
   e.printStackTrace();
  }
  return bookObj;
 }
  public void insert(int barcode,String title,String author,int noofpages,boolean haveread)
  {
	  String sql = "insert into books" +
				"(barcode,title,author,noofpages,haveread) VALUES (?, ?, ?, ?, ?)";
	  try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,barcode);
			ps.setString(2,title);
			ps.setString(3,author);
			ps.setInt(4, noofpages);
			ps.setBoolean(5,haveread);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
}
  public void delete(int barcode)
  {
  	 	String sql = "delete from books where barcode="+barcode;
  		try {
  		PreparedStatement ps = connection.prepareStatement(sql);
  		ps.executeUpdate();
  		ps.close();

  	} catch (SQLException e) {
  		throw new RuntimeException(e);

  	}
  } 
}