package com.sinchan.hibernateproject.workflow.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinchan.hibernateproject.entity.UserBookMapping;
import com.sinchan.hibernateproject.payload.ApiResponse;
import com.sinchan.hibernateproject.payload.BookDto;
import com.sinchan.hibernateproject.payload.UserDto;
import com.sinchan.hibernateproject.services.BookService;
import com.sinchan.hibernateproject.services.UserBookMappingService;
import com.sinchan.hibernateproject.services.UserService;
import com.sinchan.hibernateproject.workflow.dto.NewBookReq;

@Component
public class BookWflService {

    private static Logger LOGGER = LoggerFactory.getLogger(BookWflService.class);
    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;
    @Autowired
    UserBookMappingService mappingService;

    public ApiResponse updateAvailability(final DelegateExecution execution) throws Exception {
        Object bookReqObj = execution.getVariableTyped("reqDetail").getValue();
        LOGGER.error("bookReqObj + " + bookReqObj.toString());
        NewBookReq retObj = (NewBookReq) bookReqObj;
        LOGGER.error("retObj + " + retObj.toString());
        List<String> bookReq = retObj.getOrderDetails();

        bookReq.forEach(book -> {
            LOGGER.info("each book ===========");
            LOGGER.info(book);
            BookDto bookObj = bookService.findBookByName(book);
            int currCnt = bookObj.getBookCount();
            if (currCnt == 0) {
                LOGGER.info("cnt is 0");
                execution.setVariable("isBookAvailable", false);
                return;
            }
        });

        execution.setVariable("isBookAvailable", true);
        ApiResponse obj = new ApiResponse("Availability have been checked & Updated", "200");
        LOGGER.info("isBookAvailable --" + execution.getVariable("isBookAvailable").toString());
        LOGGER.info("end of check availability");
        LOGGER.error(obj.toString());
        return obj;
    }

    public ApiResponse allotBook(final DelegateExecution execution) throws Exception {
        LOGGER.info("Start of allotment");
        Object bookReqObj = execution.getVariableTyped("reqDetail").getValue();

        LOGGER.error("bookReqObj + " + bookReqObj.toString());
        NewBookReq retObj = (NewBookReq) bookReqObj;

        List<String> bookReq = retObj.getOrderDetails();

        UserDto user = new UserDto();
        String userName = execution.getVariable("userId").toString();
        user.setUserName(userName);
        user.setUserPassword(execution.getVariable("userPassword").toString());
        user.setUserRole("Borrower");
        UserDto ret = userService.createUser(user);

        bookReq.forEach(book -> {
            LOGGER.info("each book ==========="+book);
            BookDto dto = bookService.findBookByName(book);
            bookService.updateBookCountAfterBorrow(dto.getBookName());
            UserBookMapping mappingObj = new UserBookMapping();
            mappingObj.setBookId(dto.getBookId());
            mappingObj.setUserId(ret.getUserId());
            mappingService.saveMapping(mappingObj);

        });
        LOGGER.info("end of allotment");
        ApiResponse obj = new ApiResponse("Availability have been checked & Updated", "200");
        LOGGER.error(obj.toString());
        return obj;

    }

}
