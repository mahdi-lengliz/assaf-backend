package nst.assaf.assafbackend.repository;

import nst.assaf.assafbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
