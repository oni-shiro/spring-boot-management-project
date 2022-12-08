package com.sinchan.hibernateproject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.entity.Book;

@Service
public class UpdateDetailsService {
	@Autowired
//	BookDao bookDao;
	private static Logger LOGGER = LoggerFactory.getLogger(UpdateDetailsService.class);

	public Book findBookById(int id) {
		Book returnBook = new Book();
		try {
//			returnBook = bookDao.findById(id).get();
		} catch (Exception e) {
			LOGGER.error("error at findById method", e);
		}
		return returnBook;
	}

}
