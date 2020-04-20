package com.suryakrishnan.billingapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product
{
    @Id
    int product_code;
    String product_name;
    int product_price;
    int product_gst;

    public product() {
    }

    public product(int product_code,
                   String product_name,
                   int product_price,
                   int product_gst)
    {
        this.product_code=product_code;
        this.product_name=product_name;
        this.product_price=product_price;
        this.product_gst=product_gst;
    }

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_gst() {
        return product_gst;
    }

    public void setProduct_gst(int product_gst) {
        this.product_gst = product_gst;
    }

    @Override
    public String toString() {
        return "product{" +
                "product_code=" + product_code +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_gst=" + product_gst +
                '}';
    }
}
