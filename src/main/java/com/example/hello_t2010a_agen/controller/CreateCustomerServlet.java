package com.example.hello_t2010a_agen.controller;

import com.example.hello_t2010a_agen.entity.Customer;
import com.example.hello_t2010a_agen.model.CustomerModel;
import com.example.hello_t2010a_agen.model.MySqlCustomerModel;
import com.example.hello_t2010a_agen.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;

    public CreateCustomerServlet(){this.customerModel = new MySqlCustomerModel();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String rollnumber = req.getParameter("rollnumber");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String image = req.getParameter("image");
        String stringBirthday = req.getParameter("birthday");
        System.out.println(name);
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(rollnumber, name, phone, image, birthday);

        if (customerModel.save(customer) != null){
            resp.sendRedirect("/admin/customers/list");
        }else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
