package com.suryakrishnan.billingapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface productRepo extends JpaRepository<product,Integer>
{
    @Transactional
    @Modifying
    @Query("update product set product_price=:price,product_gst=:gst where product_code=:id")
    void updateProductData(@Param("price") int price,@Param("gst") int gst, @Param("id") int prod_id);

    @Query("from product where product_code=:code")
    product getProductData(@Param("code")int prod_code);

    @Query("from product where product_name=:name")
    product getProductDataByName(@Param("name")String name);
}