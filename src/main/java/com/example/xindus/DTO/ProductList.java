package com.example.xindus.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString

@Builder
public class ProductList {
    private int id;
    private String name;
    private int qty;
}
