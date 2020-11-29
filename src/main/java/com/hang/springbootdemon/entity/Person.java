package com.hang.springbootdemon.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author huangjh
 * @date 2020/8/30
 */
@Data
public class Person implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal income;

}
