package mk.dmt.ecomm.controller;

import lombok.RequiredArgsConstructor;
import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.dto.ProductDto;
import mk.dmt.ecomm.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @QueryMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public List<ProductDto> feedProducts(@Argument String filter, @Argument Integer skip, @Argument Integer take) {
        return productService.getAllProductsByFilterUsingPagination(filter, skip, take);
    }

    @QueryMapping
    public ProductDto getProductByProductId(@Argument String productId) {
        return productService.getProductByProductId(productId);
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
