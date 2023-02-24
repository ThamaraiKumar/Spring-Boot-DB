package com.Book_info.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Book_info.Models.Table;
import com.Book_info.Rp.Repository;

@Service
public class bookService {

	@Autowired
	Repository br;
	public Iterable<Table> sortBook(String field)
    {
  	  return br.findAll(Sort.by(Direction.DESC, field));
  	//return br.findAll(Sort.by(field));
    }
	public Iterable<Table> getData()
	{
		return br.findAll();
	}
    public Table saveBook(Table t)
    {
  	  return br.save(t);
    }
    public Page<Table>pagingBook(int page,int pageSize)
    {
  	  Pageable paging=PageRequest.of(page, pageSize);
  	  return br.findAll(paging);
    }
    public Page<Table>pagingAndSorting(int pageNo,int pageSize,String field)
    {
  	  Pageable paging=PageRequest.of(pageNo, pageSize).withSort(Sort.by(Direction.DESC, field));
  	  return br.findAll(paging);
    }
}
