package com.BookInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookInfo.entity.Book_info;
import com.BookInfo.repository.BookRepository;

@Service
public class BookService {
  
	@Autowired
	BookRepository bookRepository;
	
	public Book_info create(Book_info book)
	{
		return bookRepository.save(book);
	}
	public Optional<Book_info> read(int id)
	{
		return bookRepository.findById(id);
	}
	public Book_info update(Book_info book)
	{
		return bookRepository.save(book);
	}
	public void delete(int id)
	{
		bookRepository.deleteById(id);
	}
	public Iterable<Book_info> readAll()
	{
		return bookRepository.findAll();
	}
}
