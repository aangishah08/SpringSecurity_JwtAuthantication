package com.softvan.repository;

import com.softvan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductDetailRepo extends JpaRepository<Product,Integer> {

//    @Query("SELECT new com.demo.dto.ResponseProductDto(a.productname) from Product a WHERE a.productname=:productname ")
//    List<ResponseProductDto> findByProductName(String productname);
}
