package produims.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import produims.com.entities.Produits;

public interface ProduitsRepo  extends JpaRepository<Produits,Integer> {
}
