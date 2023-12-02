package com.alex.watchlist.controller;

import com.alex.watchlist.model.Product;
import com.alex.watchlist.model.Watchlist;
import com.alex.watchlist.model.request.ProductCreateRequest;
import com.alex.watchlist.repository.ProductRepository;
import com.alex.watchlist.repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/watchlist")
public class ProductController {

    private final ProductRepository productRepository;
    private final WatchlistRepository watchlistRepository;
    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<Product>> getAllWProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<Product>> getUserWatchlist(@PathVariable Integer id) {
        List<Watchlist> watchlist = watchlistRepository.findByUserId(id);
        List<Product> products = new ArrayList<>();

        for (Watchlist watch: watchlist
             ) {
            Product p = productRepository.findById(watch.getProductId()).orElseThrow(RuntimeException::new);
            products.add(p);
        }

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public Product getProduct(@PathVariable Integer id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/save/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity createProduct(@PathVariable Integer id, @RequestBody ProductCreateRequest product) {
        Product productAdded = productRepository.save(new Product(product.getProductName(), product.getProductUrl(), product.getPrice()));
        watchlistRepository.save(new Watchlist( id, productAdded.getId(), productAdded.getPrice(), productAdded.getAddedDate()));
        return ResponseEntity.ok().body(productAdded);
    }

    @DeleteMapping("/product/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        watchlistRepository.deleteByProductId(id);
        return ResponseEntity.ok().build();
    }
}
