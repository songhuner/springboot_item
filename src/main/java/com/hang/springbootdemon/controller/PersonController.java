package com.hang.springbootdemon.controller;

import com.hang.springbootdemon.entity.Person;
import com.hang.springbootdemon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping("/getPersonByName")
    public String getPersonById(Long id){
        Person person = personService.getPersonByid(id);
        return "person信息:"+person.toString();
    }


    @RequestMapping("/insertData")
    public String insertData(@RequestBody Person person){
        personService.insertData(person);
        return "SUCCESS";


    }
}

