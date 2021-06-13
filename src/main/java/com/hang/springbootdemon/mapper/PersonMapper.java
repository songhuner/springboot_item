package com.hang.springbootdemon.mapper;

import com.hang.springbootdemon.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PersonMapper {
    Person findPersonById(@Param("personId") Long personId);

    void insertData(@Param("person") Person person);
}
