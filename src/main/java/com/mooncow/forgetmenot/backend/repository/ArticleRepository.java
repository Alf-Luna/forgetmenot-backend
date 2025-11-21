package com.mooncow.forgetmenot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooncow.forgetmenot.backend.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {
    
    public List<Article> findAllByEmail(String email);
}
