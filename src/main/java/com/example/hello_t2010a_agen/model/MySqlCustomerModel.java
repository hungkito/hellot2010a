package com.example.hello_t2010a_agen.model;

import com.example.hello_t2010a_agen.entity.Customer;
import com.example.hello_t2010a_agen.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerModel implements CustomerModel{
    @Override
    public Customer save(Customer customer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into customers" +
                    "(rollnumber, name, phone, image, dob, createdAt, updatedAt, status)" +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, customer.getRollnumber());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getImage());
            preparedStatement.setString(5, customer.getDob().toString());
            preparedStatement.setString(6, customer.getCreatedAt().toString());
            preparedStatement.setString(7, customer.getUpdatedAt().toString());
            preparedStatement.setInt(8, customer.getStatus());
            System.out.println("Connection success");
            preparedStatement.execute();
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,1);
            System.out.println("Connection success!");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String image = resultSet.getString("image");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Customer customer = new Customer(id, name, phone, image, dob);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer findById(String rollNumber) {
        Customer customer = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from customers where customers = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, rollNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rollnumber = resultSet.getString("rollnumber");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String image = resultSet.getString("image");
                LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                customer = new Customer(rollnumber ,name, phone, image, dob);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer update(String rollnumber, Customer updateCustomer) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set rollnumber = ?, name = ?, phone = ?, image = ?, dob = ?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateCustomer.getRollnumber());
            preparedStatement.setString(2, updateCustomer.getName());
            preparedStatement.setString(3, updateCustomer.getPhone());
            preparedStatement.setString(4, updateCustomer.getImage());
            preparedStatement.setString(5, updateCustomer.getDob().toString());
            preparedStatement.setString(6, updateCustomer.getCreatedAt().toString());
            preparedStatement.setString(7, updateCustomer.getUpdatedAt().toString());
            preparedStatement.setInt(8, updateCustomer.getStatus());
            preparedStatement.setString(9, rollnumber);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String rollNumber) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update customers " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, -1);
            preparedStatement.setString(2, rollNumber);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
