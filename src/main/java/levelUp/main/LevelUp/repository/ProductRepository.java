package levelUp.main.LevelUp.repository;

import levelUp.main.LevelUp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
