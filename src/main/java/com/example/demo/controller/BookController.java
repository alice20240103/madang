package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/book/insert")
	public void insert() {		
	}
	
	@PostMapping("/book/insert")
	public String insertSumbit(Book book) {		
		service.save(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/list")
	public void list(Model model) {
		model.addAttribute("list", service.findAll());
	}	
	
	@GetMapping("/update")
	@ResponseBody
	public String update() {
		return "update";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String delete() {
		return "delete";
	}
	
	
	
}
