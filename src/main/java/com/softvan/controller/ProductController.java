package com.softvan.controller;



import com.softvan.Service.CustomProductDetailService;
import com.softvan.dto.RequestProductDto;
import com.softvan.dto.ResponseProductDto;
import com.softvan.response.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor

public class ProductController {

    private final CustomProductDetailService customProductDetailService;

//    @ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "Product add Successfully ", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.200.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.404.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 400, message = "Missing value", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.400.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//
//    })

//    @ApiOperation(value = "This api will be used to add Product", notes = "${product.info.notes}")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid RequestProductDto requestProductDto) {

            ResponseProductDto responseProductDto = this.customProductDetailService.save(requestProductDto);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Added Successfully", responseProductDto), HttpStatus.OK);
    }

//    @ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "Product Update Successfully ", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.200.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.404.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 400, message = "Missing value", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.400.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//
//    })
//
//    @ApiOperation(value = "This api will be used to Update Product", notes = "${product.info.notes}")
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse>update(@RequestBody @Valid RequestProductDto requestProductDto, @PathVariable Integer id) {


            ResponseProductDto responseProductDto = this.customProductDetailService.update(requestProductDto, id);
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product updated Successfully", responseProductDto),
                    HttpStatus.OK);

    }

//    @ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "Product Fetched Successfully ", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.200.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.404.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//    })
//    @ApiOperation(value = "This api will be used to display Products", notes = "${product.getAll.notes}")
    @GetMapping(value = "/display", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ApiResponse> findAll() {
        List<ResponseProductDto> ls = this.customProductDetailService.findAll();
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Fetched Successfully", ls), HttpStatus.OK);
    }

//    @ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "Product fetched id Successfully ", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/user.info.200.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/user.info.404.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//
//    })
//    @ApiOperation(value = "This api will be used to fetched id in Products", notes = "${product.byProductId.notes}")
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
        ResponseProductDto responseProductDto = this.customProductDetailService.findById(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Fetched id Successfully", responseProductDto), HttpStatus.OK);
    }


//    @ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "Product Delete Successfully ", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.200.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//            @io.swagger.annotations.ApiResponse(code = 404, message = "Invalid", examples = @Example(value =
//                    {@ExampleProperty(value = "file:/swagger-api-doc/example/product.info.404.example.json",
//                            mediaType = MediaType.APPLICATION_JSON_VALUE)})),
//    })
//
//    @ApiOperation(value = "This api will be used to delete Product", notes = "${product.byProductId.notes}")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
      this.customProductDetailService.delete(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Deleted successfully", Collections.emptyMap()), HttpStatus.OK);
    }

//    @GetMapping("/findbyproductname/{productname}")
//    public ResponseEntity<ApiResponse> findByProductName(@PathVariable String productname)
//    {
//        List<ResponseProductDto> ls = this.customProductDetailService.findByProductName(productname);
//        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Fetched Successfully", ls), HttpStatus.OK);
//    }
}



