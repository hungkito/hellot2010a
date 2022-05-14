package com.example.hello_t2010a_agen.controller;

import com.example.hello_t2010a_agen.entity.Customer;
import com.example.hello_t2010a_agen.model.CustomerModel;
import com.example.hello_t2010a_agen.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;

    public DeleteCustomerServlet(){this.customerModel = new MySqlCustomerModel();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rollNumber = req.getParameter("id");

        Customer customer = customerModel.findById(rollNumber);

        if (customer == null){
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = customerModel.delete(rollNumber); //xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/customers/list");
            }else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/errors/500.jsp").forward(req, resp);
            }
        }
    }
}
