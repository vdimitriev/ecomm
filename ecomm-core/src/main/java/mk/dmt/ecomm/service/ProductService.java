package mk.dmt.ecomm.service;

import lombok.RequiredArgsConstructor;
import mk.dmt.ecomm.converter.ImageDtoConverter;
import mk.dmt.ecomm.converter.ImageEntityConverter;
import mk.dmt.ecomm.converter.ProductDtoConverter;
import mk.dmt.ecomm.converter.ProductEntityConverter;
import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.dto.ProductDto;
import mk.dmt.ecomm.entity.ImageEntity;
import mk.dmt.ecomm.entity.ProductEntity;
import mk.dmt.ecomm.exception.ResourceNotFoundException;
import mk.dmt.ecomm.repository.ImageRepository;
import mk.dmt.ecomm.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService{

    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final ProductDtoConverter productDtoConverter;
    private final ProductEntityConverter productEntityConverter;

    private final ImageDtoConverter imageDtoConverter;
    private final ImageEntityConverter imageEntityConverter;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(productDtoConverter::convert).toList();
    }

    public ProductDto addProduct(ProductDto productDto) {
        ProductEntity productEntity = productEntityConverter.convert(productDto);
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        List<ImageDto> imageDtoList = productDto.getImages().stream()
                .map(imageEntityConverter::convert)
                .map(image -> {
                    image.setProduct(savedProductEntity);
                    return imageDtoConverter.convert(imageRepository.save(image));
                }).toList();
        productDto = productDtoConverter.convert(savedProductEntity);
        productDto.setImages(imageDtoList);
        return productDto;
    }

    public List<ImageDto> addImage(String productId, List<ImageDto> imageDtoList) {
        ProductEntity productEntity = productRepository.findByProductId(productId).orElseThrow(() -> new ResourceNotFoundException("Product with product id '" + productId + "'  not found"));
        return imageDtoList.stream().map(imageDto -> {
            ImageEntity imageEntity = imageEntityConverter.convert(imageDto);
            imageEntity.setProduct(productEntity);
            imageEntity = imageRepository.save(imageEntity);
            return imageDtoConverter.convert(imageEntity);
        }).toList();
    }

    public ProductDto getById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id '" + id + "'  not found"));
        return productDtoConverter.convert(productEntity);
    }

    public ProductDto getProductByProductId(String productId) {
        ProductEntity productEntity = productRepository.findByProductId(productId).orElseThrow(() -> new ResourceNotFoundException("Product with product id '" + productId + "'  not found"));
        return productDtoConverter.convert(productEntity);
    }

    public List<ProductDto> getAllProductsByFilterUsingPagination(String filter, Integer skip, Integer take) {
        return productRepository.findByNameContaining(filter, PageRequest.of(skip, take)).stream().map(productDtoConverter::convert).toList();
    }
}
