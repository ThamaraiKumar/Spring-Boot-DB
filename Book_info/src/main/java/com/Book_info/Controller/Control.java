package com.Book_info.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Book_info.BookService.bookService;
import com.Book_info.Models.Table;
import com.Book_info.Rp.Repository;

@RestController
public class Control {
  @Autowired
  bookService bs;
  @Autowired
  Repository br;
  
  @GetMapping("/get/{field}")
  Iterable<Table>bookSort(@PathVariable("field") String field)
  {
	  return bs.sortBook(field);
  }
  
  @GetMapping(value="/paging/{pageNo}/{pageSize}")
  Page<Table>bookPaging(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize)
  {
	  return bs.pagingBook(pageNo, pageSize);
  }
  
  @GetMapping(value="getps/{pageNo}/{pageSize}/{field}")
  Page<Table>bookPagingSorting(@PathVariable("pageNo") int pageno,@PathVariable("pageSize") int pageSize,@PathVariable("field") String field)
  {
	return bs.pagingAndSorting(pageno,pageSize,field); 
  }
  
  
  @GetMapping("/getdata")
  Iterable<Table> getData()
  {
	  return bs.getData();
  }
  
  @PostMapping("/post")
  public Table saveBook(@RequestBody Table t)
  {
	  return bs.saveBook(t);
  }
  @PutMapping("/put/{bookid}")
  public Table update(@RequestBody Table t)
  {
	  return bs.saveBook(t);
  }
  @DeleteMapping("/delete/{bookid}")
  public String delete(@PathVariable("bookid") int bookid)
  {
	  br.deleteById(bookid);
	  return "Deleted!";
  }
  
  
  
  
  
  
  
  
  
  
  
  /*@GetMapping("/getdata")
    List<Table> getData()
  {
	  return bs.findAll();
  }
  @PostMapping("/post")
  public String create(@RequestBody Table t)
  {
	  bs.save(t);
	  return "Saved";
  }
  @PutMapping("/put/{bookid}")
  public Table update(@RequestBody Table t)
  {
	  System.out.println("Updated!");
	  return bs.save(t);
  }
  @DeleteMapping("/delete/{bookid}")
  public String delete(@PathVariable("bookid") int id)
  {
	  bs.deleteById(id);
	  return "Deleted! "+id;
  }*/
  
 }
