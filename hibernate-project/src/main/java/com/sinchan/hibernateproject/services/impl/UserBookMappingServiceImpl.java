package com.sinchan.hibernateproject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.entity.UserBookMapping;
import com.sinchan.hibernateproject.repository.UserBookMappingRepo;
import com.sinchan.hibernateproject.services.UserBookMappingService;

@Service
public class UserBookMappingServiceImpl implements UserBookMappingService {

    @Autowired
    UserBookMappingRepo mappingRepo;

    @Override
    public void saveMapping(UserBookMapping obj) {
        UserBookMapping returnedObj = mappingRepo.save(obj);
        return;

    }

}
