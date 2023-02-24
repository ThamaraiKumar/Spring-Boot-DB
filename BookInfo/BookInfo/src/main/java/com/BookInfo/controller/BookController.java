package com.BookInfo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BookInfo.entity.Book_info;
import com.BookInfo.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Operation(summary = "creates a new book details")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "book detail created successfully"),
			@ApiResponse(responseCode="400",description="book detail is invalid")})
	
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<Book_info> create(final @RequestBody Book_info book)
	{
		Book_info createdBook=bookService.create(book);
		return ResponseEntity.ok(createdBook);
	}
	
	
	@Operation(summary = "get an book detail with an given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "getting book details successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Optional<Book_info>> read(final @PathVariable int id)
	{
		Optional<Book_info> readBook=bookService.read(id);
		return ResponseEntity.ok(readBook);
	}
	
	
	@Operation(summary = "updates an book with an given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "book details updated successfully"),
			@ApiResponse(responseCode="400",description="book details is invalid"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@PutMapping(value="/{id}",produces="application/json",consumes="application/json")
	public ResponseEntity<Book_info> update(final @RequestBody Book_info book) throws JsonProcessingException
		{
			final Book_info updateBook=bookService.update(book);
			return ResponseEntity.ok(updateBook);
		}
	
	
	@Operation(summary = "Deletes a book detail with an given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "book detail deleted successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@DeleteMapping("/{id}")
	public void delete(final @PathVariable int id)
	{
		bookService.delete(id);
	}
	
	@Operation(summary = "get all book detail")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "getting book details successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@GetMapping(produces="application/json")
	public Iterable<Book_info> readAll()
	{
		return bookService.readAll();
	}

}
