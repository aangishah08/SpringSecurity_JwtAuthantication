package com.softvan.Service;


import com.softvan.dto.RequestProductDto;
import com.softvan.dto.ResponseProductDto;
import com.softvan.entity.Product;
import com.softvan.enums.CustomEnums;
import com.softvan.exception.CustomException;
import com.softvan.repository.ProductDetailRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomProductDetailServiceImpl implements CustomProductDetailService {

    private final ProductDetailRepo productDetailRepo;

    private final ModelMapper modelMapper;


    @Override
    public ResponseProductDto save(RequestProductDto requestProductDto) {

        Product product = this.productDetailRepo.save(modelMapper.map(requestProductDto, Product.class));
        return modelMapper.map(product, ResponseProductDto.class);
    }

    @Override
    public ResponseProductDto update(RequestProductDto dto, Integer id) {
        Product product = this.searchById(id);
        product.setBrand(dto.getBrand());
        product.setQty(dto.getQty());
        product.setProductname(dto.getProductname());
        product.setPrice(dto.getPrice());
        product = productDetailRepo.save(product);
        return modelMapper.map(product, ResponseProductDto.class);
    }



    @Override
        public List<ResponseProductDto> findAll() {
            List<Product> ls= this.productDetailRepo.findAll();
            return ls.stream().map(this::mapToResponseProductDto
                    ).collect(Collectors.toList());
        }

    @Override
    public ResponseProductDto findById(Integer id) {
        return modelMapper.map(this.searchById(id), ResponseProductDto.class);
    }

    private Product searchById(Integer id){
        return productDetailRepo.findById(id).orElseThrow(()->
                new CustomException(CustomEnums.NOT_FOUND.getValue(), HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(Integer id) {
        this.searchById(id);
        this.productDetailRepo.deleteById(id);
    }

    public ResponseProductDto mapToResponseProductDto(Product product){
        return modelMapper.map(product, ResponseProductDto.class);
    }

//    @Override
//    public List<ResponseProductDto> findByProductName(String productname) {
//        return this.productDetailRepo.findByProductName(productname);
//    }
}
