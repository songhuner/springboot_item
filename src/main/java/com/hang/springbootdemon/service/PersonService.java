package com.hang.springbootdemon.service;

import com.hang.springbootdemon.entity.Person;

public interface PersonService {
    /**
     * 根据personid查全表
     * @param personId
     * @return
     */
  Person getPersonByid(Long personId);

    void insertData(Person person);
}
