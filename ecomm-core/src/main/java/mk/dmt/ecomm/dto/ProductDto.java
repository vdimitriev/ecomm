package mk.dmt.ecomm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productId;
    private String name;
    private String price;
    private String status;
    private List<ImageDto> images = new ArrayList<>();
}
