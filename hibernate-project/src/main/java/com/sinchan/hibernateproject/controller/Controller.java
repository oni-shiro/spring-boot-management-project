package com.sinchan.hibernateproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.constants.StringConstants;
import com.sinchan.hibernateproject.entity.Book;
import com.sinchan.hibernateproject.services.UpdateDetailsService;

/***
 * @author sinchan
 */
@RestController
public class Controller {

	@Autowired
	UpdateDetailsService updtService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return StringConstants.running;
	}
	@RequestMapping(value ="/getBook/{id}",method=RequestMethod.GET)
	public Book getBookById(@PathVariable("id") int id){
		return updtService.findBookById(id);
	}

	

}
