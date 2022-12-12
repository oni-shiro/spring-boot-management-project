package com.sinchan.hibernateproject.workflow.service;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinchan.hibernateproject.entity.UserBookMapping;
import com.sinchan.hibernateproject.payload.BookDto;
import com.sinchan.hibernateproject.payload.UserDto;
import com.sinchan.hibernateproject.services.BookService;
import com.sinchan.hibernateproject.services.UserBookMappingService;
import com.sinchan.hibernateproject.services.UserService;

@Component
public class BookWflService {

    
    

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;
    @Autowired
    UserBookMappingService mappingService;

    public void updateAvailability(DelegateExecution execution) {
        List<String> bookReq = execution.getVariableTyped("reqDetail");

        bookReq.forEach(book -> {
            BookDto bookObj = bookService.findBookByName(book);
            int currCnt = bookObj.getBookCount();
            if (currCnt == 0) {
                execution.setVariable("isBookAvailable", false);
                return;
            }
        });
        execution.setVariable("isBookAvailable", true);
        return;
    }

    public void allotBook(DelegateExecution execution) {
        List<String> bookReq = execution.getVariableTyped("reqDetail");

        UserDto user = new UserDto();
        String userName = execution.getVariable("userId").toString();
        user.setUserName(userName);
        user.setUserPassword(execution.getVariable("userPassword").toString());
        user.setUserRole("Borrower");
        UserDto ret = userService.createUser(user);

        bookReq.forEach(book -> {
            BookDto dto = bookService.findBookByName(book);
            bookService.updateBookCountAfterBorrow(dto.getBookName());
            UserBookMapping mappingObj = new UserBookMapping();
            mappingObj.setBookId(dto.getBookId());
            mappingObj.setUserId(ret.getUserId());
            mappingService.saveMapping(mappingObj);

        });
    }

}
