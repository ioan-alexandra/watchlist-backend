package com.alex.watchlist.Controller;

import com.alex.watchlist.model.Product;
import com.alex.watchlist.model.request.ProductCreateRequest;
import com.alex.watchlist.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class ProductControllerTest {
    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductCreateRequest productCreateRequest;

    @BeforeEach
    public void setUp()  {

        List<Product> products = List.of(
                new Product("test", "urlllllllllllllll1.com", 200.90),
                new Product("test2", "urlllllllllllllll2.com", 100.80)
        );
        when(productRepository.findAll()).thenReturn(products);
    }

    @Test
    public void getAllProductsTest()
    {
        // act
        List<Product> products = productRepository.findAll();
        // assert
        Assertions.assertEquals(products.get(0).getProductName(),"test");
        Assertions.assertEquals(products.get(1).getProductName(),"test2");


        Assertions.assertEquals(products.get(0).getPrice(),200.90);
        Assertions.assertEquals(products.get(1).getPrice(),100.80);
    }

    @Test
    public void updateProductTest()
    {
        Product product = new Product("test3", "urlllllllllllllll3.com", 230.90);

        // act
        List<Product> products = productRepository.findAll();

        products.get(0).setProductName(product.getProductName());
        products.get(0).setProductUrl(product.getProductUrl());
        products.get(0).setPrice(product.getPrice());

        // assert
        Assertions.assertEquals(products.get(0).getProductName(),"test3");
        Assertions.assertEquals(products.get(0).getProductUrl(),"urlllllllllllllll3.com");
        Assertions.assertEquals(products.get(0).getPrice(),230.90);
    }
    @Test
    public void getProductByUrlTest()
    {
        // act
        List<Product> products = productRepository.findAll();
        Product p = productRepository.findByUrl("urlllllllllllllll1.com").orElseThrow();
        // assert
        Assertions.assertEquals(products.get(0).getProductName(),p.getProductName());
    }
}
