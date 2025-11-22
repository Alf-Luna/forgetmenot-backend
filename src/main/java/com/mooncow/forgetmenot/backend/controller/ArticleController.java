package com.mooncow.forgetmenot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mooncow.forgetmenot.backend.model.Article;
import com.mooncow.forgetmenot.backend.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    ArticleService articleService;

    @GetMapping("/welfarecheck")
    public String getMethodName() {
        return new String("ok");
    }

    @PostMapping
    public ResponseEntity<Article> create(@RequestBody Article article) {
        Article created = articleService.create(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAll() {
        return ResponseEntity.ok(articleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable Long id) {
        return articleService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update(
            @PathVariable Long id,
            @RequestBody Article updatedArticle
    ) {
        try {
            Article updated = articleService.update(id, updatedArticle);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            articleService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all/mail")
    public ResponseEntity<List<Article>> getAllByEMail(@RequestParam String email) {
        return ResponseEntity.ok(articleService.getAllByEMail(email));
    }
}
