package com.softvan.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RequestProductDto {
    @NotEmpty(message = "productname should not be empty")
    String productname;

    @NotNull(message = "price should not be null")
    Integer price;

    @NotNull(message = "qty should not be null")
    Integer qty;
    @NotEmpty(message = "brand should not be null")
    String brand;

}
