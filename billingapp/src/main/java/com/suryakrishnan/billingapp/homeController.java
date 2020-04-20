package com.suryakrishnan.billingapp;

import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class homeController
{

    @Autowired
    productRepo prod_repo_object;

    List<product>prod_by_name_array= new ArrayList<>();
    List<product>prod_by_id_array= new ArrayList<>();

    @RequestMapping("/")
    public String home(Model m)
    {
        System.out.println("Home Page Requested");

        List<product> all_products= prod_repo_object.findAll();

        m.addAttribute("allProducts",all_products);

        return "product";
    }

    @RequestMapping("BillProduct")
    public String viewBill(Model m)
    {
        System.out.println("Bill Page Requested");
        m.addAttribute("test","GG boiss");

        return "billing";
    }

    @RequestMapping("addProduct")
    public String addNewProduct(@ModelAttribute("productData") product prod,Model m)
    {
        prod_repo_object.save(prod);
        //System.out.print(prod);
        List<product> all_products= prod_repo_object.findAll();

        m.addAttribute("allProducts",all_products);

        return "product";

    }

    @RequestMapping("getProductByCode")
    public String getProduct(@RequestParam("product_code") int prod_code,Model m)
    {
        product obj  = prod_repo_object.getProductData(prod_code);
        prod_by_id_array.add(obj);

        m.addAttribute("result",prod_by_id_array);

        return "billing";
    }

    @RequestMapping("getProductByName")
    public String getProductName(@RequestParam("product_name") String prod_name,Model m)
    {
        product obj  = prod_repo_object.getProductDataByName(prod_name);

        prod_by_name_array.add(obj);

        m.addAttribute("result",prod_by_name_array);

        return "billing";
    }

    @RequestMapping("updateProduct")
    public String updateProduct(@RequestParam("product_price") int price,@RequestParam("product_gst") int gst
            ,@RequestParam("product_code")int product_id,Model m)
    {
        prod_repo_object.updateProductData(price,gst,product_id);

        List<product> all_products= prod_repo_object.findAll();

        m.addAttribute("allProducts",all_products);

        return "product";
    }





}
