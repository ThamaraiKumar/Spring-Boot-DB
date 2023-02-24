package com.BookInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookInfo.entity.Book_info;

public interface BookRepository extends JpaRepository<Book_info, Integer>{

}
