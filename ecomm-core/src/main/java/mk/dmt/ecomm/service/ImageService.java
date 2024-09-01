package mk.dmt.ecomm.service;

import lombok.RequiredArgsConstructor;
import mk.dmt.ecomm.converter.ImageDtoConverter;
import mk.dmt.ecomm.converter.ImageEntityConverter;
import mk.dmt.ecomm.dto.ImageDto;
import mk.dmt.ecomm.entity.ImageEntity;
import mk.dmt.ecomm.exception.ResourceNotFoundException;
import mk.dmt.ecomm.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageDtoConverter imageDtoConverter;
    private final ImageEntityConverter imageEntityConverter;

    public ImageDto getById(Long id) {
        ImageEntity imageEntity = imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image with id '" + id + "'  not found"));
        return imageDtoConverter.convert(imageEntity);
    }

    public ImageDto getByImageId(String imageId) {
        ImageEntity imageEntity = imageRepository.findByImageId(imageId).orElseThrow(() -> new ResourceNotFoundException("Image with image id '" + imageId + "'  not found"));
        return imageDtoConverter.convert(imageEntity);
    }

    public List<ImageDto> getAllImages() {
        return imageRepository.findAll().stream().map(imageDtoConverter::convert).toList();
    }

    public List<ImageDto> getAllImagesByProductId(String productId) {
        return imageRepository.findAllByProductId(productId).stream().map(imageDtoConverter::convert).toList();
    }
}
