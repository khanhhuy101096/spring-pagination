package com.example.springpagination.repository;

import com.example.springpagination.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String term);

}
