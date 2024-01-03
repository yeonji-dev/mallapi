package com.yeonjidev.mallapi.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    private String fileName;
    private int ord;    //대표 이미지 출력 용도
    public void setOrd(int ord){
        this.ord = ord;
    }
}
