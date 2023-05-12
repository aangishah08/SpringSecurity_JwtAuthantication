package com.softvan.dto;

import lombok.*;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseProductDto {

    Integer id;
    String productname;
    Integer price;
    Integer qty;
    String brand;



}