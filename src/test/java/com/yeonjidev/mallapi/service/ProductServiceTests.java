package com.yeonjidev.mallapi.service;

import com.yeonjidev.mallapi.dto.PageRequestDTO;
import com.yeonjidev.mallapi.dto.PageResponseDTO;
import com.yeonjidev.mallapi.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);
        result.getDtoList().forEach(dto -> log.info(dto.toString()));
    }

    @Test
    public void testRegister(){
        ProductDTO productDTO = ProductDTO.builder()
                .pname("새로운 상품")
                .pdesc("신규 추가 상품입니다.")
                .price(1000)
                .build();

        productDTO.setUploadFileNames(
                java.util.List.of(
                        UUID.randomUUID() + "_" + "Test1.jpg",
                        UUID.randomUUID() + "_" + "Test2.jpg"
                )
        );

        productService.register(productDTO);
    }

    @Test
    public void testRead(){
        Long pno = 13L;
        ProductDTO productDTO = productService.get(pno);
        log.info(productDTO.toString());
        log.info(productDTO.getUploadFileNames().toString());
    }
}
