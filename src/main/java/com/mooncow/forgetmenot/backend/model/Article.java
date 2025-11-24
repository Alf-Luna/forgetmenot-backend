package com.mooncow.forgetmenot.backend.model;

import com.mooncow.forgetmenot.backend.dto.ArticleDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imgUrl;

    private String category;

    private String price;

    private String condition;

    private String acquisitionDate;

    private String location;

    private String email;

    // List<String> tags;

    public Article(ArticleDto dto){
        this.name = dto.getName();
        this.imgUrl = dto.getImgUrl();
        this.category = dto.getCategory();
        this.price = dto.getPrice();
        this.condition = dto.getCondition();
        this.acquisitionDate = dto.getAcquisitionDate();
        this.location = dto.getLocation();
        this.email = dto.getEmail();
    }
}