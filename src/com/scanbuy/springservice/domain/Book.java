package com.scanbuy.springservice.domain;
public class Book
{
private int barcode;
private String title;
private String author;
private int noofpages;
private boolean haveread;
 
public Book()
{
 
}
 
public Book(int barcode, String title, String author, int noofpages,boolean haveread)
{
super();
this.barcode = barcode;
this.title = title;
this.author = author;
this.noofpages = noofpages;
this.haveread=haveread;
}
 
public int getBarcode()
{
return barcode;
}
 
public void setBarcode(int barcode)
{
this.barcode = barcode;
}
 
public String getTitle()
{
return title;
}
 
public void setTitle(String title)
{
this.title = title;
}
 
public String getAuthor()
{
return author;
}
 
public void setAuthor(String author)
{
this.author = author;
}
 
public int getNoofpages()
{
return noofpages;
}
 
public void setNoofpages(int noofpages)
{
this.noofpages = noofpages;
}
public boolean getHaveread()
{
return haveread;
}
 
public void setHaveread(boolean haveread)
{
this.haveread=haveread;
}
 
@Override
public String toString()
{
return "Book [Barcode=" + barcode + ", Title=" + title + ", Author=" + author
+ ", No of pages=" +noofpages+",Have read="+haveread+"]";
}
 
}