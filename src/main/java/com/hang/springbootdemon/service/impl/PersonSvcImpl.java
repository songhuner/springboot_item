package com.hang.springbootdemon.service.impl;

import com.hang.springbootdemon.entity.Person;
import com.hang.springbootdemon.mapper.PersonMapper;
import com.hang.springbootdemon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangjh
 * @date 2020/9/8
 */
@Service
public class PersonSvcImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public Person getPersonByid(Long personId) {
        return personMapper.findPersonById(personId);
    }
}
