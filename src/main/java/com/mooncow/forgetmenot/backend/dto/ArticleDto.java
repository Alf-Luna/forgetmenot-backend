package com.mooncow.forgetmenot.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto { //solo pa recibir el que manda el backend
    private Long id;
    private String name;
    private String imgUrl;
    private String category;
    private String price;
    private String condition;
    private String acquisitionDate;
    private String location;
    private String email;
}
