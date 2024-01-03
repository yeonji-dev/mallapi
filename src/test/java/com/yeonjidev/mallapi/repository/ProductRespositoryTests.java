package com.yeonjidev.mallapi.repository;

import com.yeonjidev.mallapi.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class ProductRespositoryTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testInsert(){
        for(int i = 0; i < 10; i++){
            Product product = Product.builder()
                    .pname("상품"+i)
                    .price(100*1)
                    .pdesc("상품설명 " + i)
                    .build();

            product.addImageString(UUID.randomUUID().toString() + "_" + "IMAGE1.jpg");
            product.addImageString(UUID.randomUUID().toString() + "_" + "IMAGE2.jpg");

            productRepository.save(product);

            log.info("======================");
        }
    }

    @Transactional
    @Test
    public void testRead(){
        Long pno = 1L;
        Optional<Product> result = productRepository.findById(pno);
        Product product = result.orElseThrow();

        log.info(product.toString());
        log.info(product.getImageList().toString());
    }

    @Test
    public void testRead2(){
        Long pno = 10L;
        Optional<Product> result = productRepository.selectOne(pno);
        Product product = result.orElseThrow();
        log.info(product.toString());
        log.info(product.getImageList().toString());
    }

    @Commit
    @Transactional
    @Test
    public void testDelete(){
        Long pno = 2L;

        productRepository.updateToDelete(pno, true);
    }

    @Test
    public void testUpdate(){
        Long pno = 10L;
        Product product = productRepository.selectOne(pno).get();
        product.changeName("10번 상품");
        product.changeDesc("10번 상품 설명입니다.");
        product.changePrice(5000);

        product.clearList();

        product.addImageString(UUID.randomUUID().toString() + "_" + "NEWIMAGE1.jpg");
        product.addImageString(UUID.randomUUID().toString() + "_" + "NEWIMAGE2.jpg");
        product.addImageString(UUID.randomUUID().toString() + "_" + "NEWIMAGE3.jpg");

        productRepository.save(product);
    }

    @Test
    public void testList(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
        Page<Object[]> result = productRepository.selectList(pageable);
        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
    }
}
