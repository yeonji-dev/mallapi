package com.yeonjidev.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_product")
@Getter
@ToString(exclude = "imageList")    //쿼리실행시 Image 관련 엔티티는 제외
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;
    private int price;
    private String pdesc;
    private boolean delFlag;

    @ElementCollection  //기본적으로 lazy loading 방식으로 동작
    @Builder.Default
    private List<ProductImage> imageList = new ArrayList<>();

    public void changePrice(int price){
        this.price = price;
    }

    public void changeDesc(String pdesc){
        this.pdesc = pdesc;
    }

    public void changeName(String pname){
        this.pname = pname;
    }

    public void addImage(ProductImage image){
        image.setOrd(this.imageList.size());
        imageList.add(image);
    }

    public void addImageString(String fileName){
        ProductImage productImage = ProductImage.builder()
                .fileName(fileName)
                .build();
        addImage(productImage);
    }

    public void clearList(){
        this.imageList.clear();
    }
}
