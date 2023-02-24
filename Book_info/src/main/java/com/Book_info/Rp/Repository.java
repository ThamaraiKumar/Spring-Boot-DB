package com.Book_info.Rp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.Book_info.Models.Table;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Table,Integer>,PagingAndSortingRepository<Table, Integer> {
       
	
}
