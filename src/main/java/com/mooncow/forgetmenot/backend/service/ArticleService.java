package com.mooncow.forgetmenot.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooncow.forgetmenot.backend.model.Article;
import com.mooncow.forgetmenot.backend.repository.ArticleRepository;

@Service
public class ArticleService {
    
    @Autowired
    ArticleRepository articleRepository;

    public Article create(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> getById(Long id) {
        return articleRepository.findById(id);
    }

    public Article update(Long id, Article updated) {
        if (articleRepository.findById(updated.getId()).isPresent()){
            Article updatedArticle = Article.builder()
                .id(updated.getId())
                .name(updated.getName())
                .imgUrl(updated.getImgUrl())
                .category(updated.getCategory())
                .price(updated.getPrice())
                .condition(updated.getCondition())
                .acquisitionDate(updated.getAcquisitionDate())
                .location(updated.getLocation())
                .email(updated.getEmail())
                .build();
            return articleRepository.save(updatedArticle);
        }
        throw new RuntimeException("Articulo con la id " + id + " no encontrado");
    }

    public void delete(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Article not found with id: " + id);
        }
        articleRepository.deleteById(id);
    }

    public List<Article> getAllByEMail(String email) {
        return articleRepository.findAllByEmail(email);
    }
}
