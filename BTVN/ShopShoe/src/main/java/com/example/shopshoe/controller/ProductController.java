package com.example.shopshoe.controller;

import com.example.shopshoe.model.Account;
import com.example.shopshoe.model.Image;
import com.example.shopshoe.model.Product;
import com.example.shopshoe.model.Role;
import com.example.shopshoe.service.impl.AccountServiceImpl;
import com.example.shopshoe.service.impl.ImageServiceImpl;
import com.example.shopshoe.service.impl.ProductServiceImpl;
import com.example.shopshoe.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ImageServiceImpl imageService;

    //ADMIN_PAGE
    @GetMapping("/admin/product")
    public String showProduct(Model model) {
        model.addAttribute("productList", productService.getAll());
        return "adminView/product";
    }
    @GetMapping("/admin/product/create")
    public String showCreate(Model model) {
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("imageList", imageService.getAll());
        return "adminView/productCreate";
    }
    @PostMapping("/admin/product/create")
    public String create(@ModelAttribute Product product, @RequestParam("idImage") Image image) {
        productService.save(product, image);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("imageList", imageService.getAll());
        return "adminView/productEdit";
    }
    @PostMapping("/admin/product/edit")
    public String edit(@ModelAttribute Product product, @RequestParam("idImage") Image image) {
        productService.edit(product, image);
        return "redirect:/admin/product";
    }
    @GetMapping("/admin/product/delete")
    public String delete(@RequestParam int id) {
        Product product = productService.findById(id);
        productService.delete(product);
        return "redirect:/admin/product";
    }
    //INDEX_PAGE
    @GetMapping("/product")
    public String product() {
        return "homeView/product";
    }

}
