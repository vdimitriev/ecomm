package mk.dmt.ecomm.converter;

import mk.dmt.ecomm.dto.ProductDto;
import mk.dmt.ecomm.entity.ProductEntity;
import mk.dmt.ecomm.entity.ProductStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

@Component
public class ProductEntityConverter implements Converter<ProductDto, ProductEntity>  {
    @Override
    public ProductEntity convert(ProductDto source) {
        return new ProductEntity(null,
                UUID.randomUUID().toString(),
                source.getName(),
                BigDecimal.valueOf(Double.parseDouble(source.getPrice())),
                ProductStatus.valueOf(source.getStatus()),
                Collections.emptyList()
        );
    }
}
