package com.cuonghd.id8872.service;

import com.cuonghd.id8872.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    List<Customer> customerList;

    public CustomerService() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "T", "t@codegym.vn", "Da Nang"));
        customerList.add(new Customer(2, "Nhat", "nhat@codegym.vn", "Ha Noi"));
        customerList.add(new Customer(3, "Trang", "trang@codegym.vn", "Quang Tri"));
        customerList.add(new Customer(4, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"));
        customerList.add(new Customer(5, "Dang xuan Hoa", "hoa@codegym.vn", "Nha Trang"));
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    public Customer findCustomerById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) return customer;
        }
        return null;
    }
    public int findIndexById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) return i;
        }
        return -1;
    }
    public void editCustomer(int id, Customer customer) {
        int index = findIndexById(id);
        if (index != -1) {
            customerList.set(index, customer);
        }
    }
    public void createCustomer(Customer customer) {
        customerList.add(customer);
    }
    public void deleteCustomer(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            customerList.remove(index);
        }
    }
}
