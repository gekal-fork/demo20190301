package com.example.demo.web.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private int id;
    private  String name;
}
