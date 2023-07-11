package com.example.id8915.controller;


import com.example.id8915.model.Customer;
import com.example.id8915.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public String showCustomer(Model model) {
        model.addAttribute("customerList", customerService.getCustomerList());
        return "showCustomer";
    }
    @GetMapping("/editCustomer")
    public String showEditCustomer(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "editCustomer";
    }

    @PostMapping("/editCustomer")
    public String editStudent(@ModelAttribute Customer customer) {
        customerService.editCustomer(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/createCustomer")
    public String showCreateCustomer() {
        return "createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }
    @GetMapping("/deleteCustomer")
    public String showDeleteCustomer(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "deleteCustomer";
    }
    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }

}
