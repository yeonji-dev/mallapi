package com.yeonjidev.mallapi.service;

import com.yeonjidev.mallapi.dto.PageRequestDTO;
import com.yeonjidev.mallapi.dto.PageResponseDTO;
import com.yeonjidev.mallapi.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductService {
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    Long register(ProductDTO productDTO);

    ProductDTO get(Long pno);

    void modify(ProductDTO productDTO);

    void remove(Long pno);
}
