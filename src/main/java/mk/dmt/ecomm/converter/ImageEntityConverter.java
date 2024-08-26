package mk.dmt.ecomm.converter;

import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.entity.ImageEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ImageEntityConverter implements Converter<ImageDto, ImageEntity> {
    @Override
    public ImageEntity convert(ImageDto source) {
        return new ImageEntity(null, UUID.randomUUID().toString(), source.getUrl(), 100, null);
    }
}
