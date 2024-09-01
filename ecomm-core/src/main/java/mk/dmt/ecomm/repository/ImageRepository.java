package mk.dmt.ecomm.repository;

import mk.dmt.ecomm.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {


    @Query("SELECT image FROM ImageEntity image WHERE image.imageId = :imageId ")
    Optional<ImageEntity> findByImageId(@Param("imageId") String imageId);

    @Query("SELECT image FROM ImageEntity image WHERE image.product.productId = :productId ")
    List<ImageEntity> findAllByProductId(@Param("productId") String productId);
}
