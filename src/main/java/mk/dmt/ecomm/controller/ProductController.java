package mk.dmt.ecomm.controller;

import lombok.RequiredArgsConstructor;
import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.dto.ProductDto;
import mk.dmt.ecomm.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @QueryMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @MutationMapping
    public ProductDto createProduct(@Argument(value = "product") ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @MutationMapping
    public List<ImageDto> addProductImages(@Argument String productId, @Argument List<ImageDto> images) {
        return productService.addImage(productId, images);
    }
}
