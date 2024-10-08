package mk.dmt.ecomm.controller;

import lombok.RequiredArgsConstructor;
import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.service.ImageService;
import org.springframework.graphql.data.federation.EntityMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @QueryMapping
    public ImageDto getImageByImageId(@Argument String imageId) {
        return imageService.getByImageId(imageId);
    }

    @QueryMapping
    public List<ImageDto> getAllImages() {
        return imageService.getAllImages();
    }

    @QueryMapping
    public List<ImageDto> getAllImagesByProductId(@Argument String productId) {
        return imageService.getAllImagesByProductId(productId);
    }
}
