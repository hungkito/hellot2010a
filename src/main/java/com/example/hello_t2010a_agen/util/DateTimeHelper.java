package com.example.hello_t2010a_agen.util;

import com.example.hello_t2010a_agen.controller.CreateCustomerServlet;
import com.example.hello_t2010a_agen.entity.Customer;
import com.example.hello_t2010a_agen.model.CustomerModel;
import com.example.hello_t2010a_agen.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {


    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final LocalDateTime convertStringToLocalDateTime(String date){
        return LocalDate.parse(date, formatter).atStartOfDay();
    }

    public static String convertLocalDateTimeToString(LocalDateTime date){
        return date.format(formatter);
    }
}
