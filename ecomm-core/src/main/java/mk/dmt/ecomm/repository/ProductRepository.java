package mk.dmt.ecomm.repository;

import mk.dmt.ecomm.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>  {

    @Query("SELECT product FROM ProductEntity product WHERE product.productId = :productId ")
    Optional<ProductEntity> findByProductId(@Param("productId") String productId);

    List<ProductEntity> findByNameContaining(String name, Pageable pageable);
}
