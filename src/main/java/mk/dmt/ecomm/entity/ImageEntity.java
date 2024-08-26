package mk.dmt.ecomm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_id")
    private String imageId;

    @Column(name = "url")
    private String url;

    @Column(name = "priority")
    private Integer priority;

    @ManyToOne(cascade ={ CascadeType.PERSIST,CascadeType.MERGE}, targetEntity = ProductEntity.class)
    private ProductEntity product = new ProductEntity();
}
