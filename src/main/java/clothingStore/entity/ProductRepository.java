package clothingStore.entity;

import clothingStore.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product,String> {
}
