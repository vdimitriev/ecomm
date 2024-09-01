package mk.dmt.ecomm.converter;

import lombok.RequiredArgsConstructor;
import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.dto.ProductDto;
import mk.dmt.ecomm.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDtoConverter implements Converter<ProductEntity, ProductDto>  {

    private final ImageDtoConverter imageDtoConverter;

    @Override
    public ProductDto convert(ProductEntity source) {
        final List<ImageDto> productImages = source.getImages().stream().map(imageDtoConverter::convert).toList();
        return new ProductDto(source.getId(),
                source.getProductId(),
                source.getName(),
                source.getPrice().toString(),
                source.getStatus().name(),
                productImages
        );
    }
}
