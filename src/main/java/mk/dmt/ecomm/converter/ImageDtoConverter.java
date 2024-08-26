package mk.dmt.ecomm.converter;

import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.entity.ImageEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ImageDtoConverter implements Converter<ImageEntity, ImageDto>  {
    @Override
    public ImageDto convert(ImageEntity source) {
        return new ImageDto(source.getId(),
                source.getImageId(),
                source.getUrl(),
                source.getPriority()
        );
    }
}
