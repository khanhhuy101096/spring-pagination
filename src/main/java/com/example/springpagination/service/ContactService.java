package com.example.springpagination.service;

import com.example.springpagination.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ContactService {

    Page<Contact> findAll(PageRequest pageRequest);

    List<Contact> search(String term);

    Contact findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);
}
