package com.example.springpagination.controller;

import com.example.springpagination.entity.Contact;
import com.example.springpagination.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/home")
    public String home(@RequestParam(value = "pages", required = false, defaultValue = "0") int pages,
                       @RequestParam(value = "size", required = false, defaultValue = "5") int size
                , Model model){
        Page<Contact> contactPage = contactService.findAll(PageRequest.of(pages, size));
        model.addAttribute("contactPage", contactPage);
        model.addAttribute("pageSizes", new ArrayList<Integer>(Arrays.asList(5,10,25,50,100)));
        model.addAttribute("size", size);
        return "index";
    }

}
