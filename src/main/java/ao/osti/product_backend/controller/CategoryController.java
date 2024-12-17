package ao.osti.product_backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ao.osti.product_backend.models.Category;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
public class CategoryController {
    private List<Category> categories = Arrays.asList(new Category(1, "Produção Própria"),
            new Category(2, "Nacional"),
            new Category(3, "Importada"),
            new Category(4, "Outras"));

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategorie(@PathVariable int id) {
        Category cat = categories.stream()
                .filter(categori -> categori.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categories not found..!"));

        return ResponseEntity.ok(cat);
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categories;
    }
}
