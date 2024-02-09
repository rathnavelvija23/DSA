package com.Java.MultiThreading.Database;

import com.Java.MultiThreading.DTO.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataBase {

    public static List<Employee> getEmployee(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           return objectMapper.readValue(new File("employee.json"), new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
