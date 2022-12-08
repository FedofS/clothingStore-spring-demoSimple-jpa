package clothingStore;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @ManyToMany()
    private List<Product> products = new ArrayList<>();

//        public void addProduct(Product product) {
//        this.products.add(product);
//    }

}
