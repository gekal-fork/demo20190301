package com.example.demo.common.controller.resource;

import com.example.demo.domain.dto.common.Dto;

import java.util.List;

public interface Resource {

    List<? extends Dto> getData();

    void setData(List<? extends Dto> data);

    String getMessage();

    void setMessage(String message);
}
