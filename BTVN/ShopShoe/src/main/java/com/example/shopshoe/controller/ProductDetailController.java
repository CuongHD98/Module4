package com.example.shopshoe.controller;

import com.example.shopshoe.model.*;
import com.example.shopshoe.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductDetailController {
    @Autowired
    private ProductDetailServiceImpl productDetailService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ColorServiceImpl colorService;
    @Autowired
    private SizeServiceImpl sizeService;

    //ADMIN_PAGE
    @GetMapping("/admin/productdetail")
    public String showProductDetail(Model model) {
        model.addAttribute("productDetailList", productDetailService.getAll());
        return "adminView/productDetail";
    }
    @GetMapping("/admin/productdetail/create")
    public String showCreate(Model model) {
        model.addAttribute("productDetailList", productDetailService.getAll());
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("colorList", colorService.getAll());
        model.addAttribute("sizeList", sizeService.getAll());
        return "adminView/productDetailCreate";
    }
    @PostMapping("/admin/productdetail/create")
    public String create(@ModelAttribute ProductDetail productDetail,
                         @RequestParam("idProduct") Product product,
                         @RequestParam("idColor") Color color,
                         @RequestParam("idSize") Size size) {
        productDetailService.save(productDetail, product, color, size);
        return "redirect:/admin/productdetail";
    }
    @GetMapping("/admin/productdetail/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("productDetail", productDetailService.findById(id));
        model.addAttribute("productList", productService.getAll());
        model.addAttribute("colorList", colorService.getAll());
        model.addAttribute("sizeList", sizeService.getAll());
        return "adminView/productDetailEdit";
    }
    @PostMapping("/admin/productdetail/edit")
    public String edit(@ModelAttribute ProductDetail productDetail,
                       @RequestParam("idProduct") Product product,
                       @RequestParam("idColor") Color color,
                       @RequestParam("idSize") Size size) {
        productDetailService.edit(productDetail, product, color, size);
        return "redirect:/admin/productdetail";
    }
    @GetMapping("/admin/productdetail/delete")
    public String delete(@RequestParam int id) {
        ProductDetail productDetail = productDetailService.findById(id);
        productDetailService.delete(productDetail);
        return "redirect:/admin/productdetail";
    }

    //INDEX_PAGE
    @GetMapping("/productdetail")
    public String productDetail() {
        return "homeView/productDetail";
    }

}
