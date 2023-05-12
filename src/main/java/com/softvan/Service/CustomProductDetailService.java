package com.softvan.Service;



import com.softvan.dto.RequestProductDto;
import com.softvan.dto.ResponseProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomProductDetailService {
    ResponseProductDto save(RequestProductDto requestProductDto);
       List<ResponseProductDto> findAll();
      ResponseProductDto findById(Integer id);
       void delete(Integer id);
       ResponseProductDto update(RequestProductDto requestProductDto,Integer id);

//       List<ResponseProductDto> findByProductName(String productname);
}
