package clothingStore.web;


import clothingStore.Basket;
import clothingStore.Product;
import clothingStore.entity.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/departments")
@SessionAttributes("basket")
public class DepartmentController {

    private final ProductRepository productRepository;

    public DepartmentController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ModelAttribute
    public void addProductsModel(Model model){

        //      another option (not used)
        Iterable<Product> ingredients = productRepository.findAll();

        List<Product> ingrs = new ArrayList<>();
        productRepository.findAll().forEach(ingrs::add);

        List<Product> ingredientsShoes = ingrs.stream()
                .filter(p -> p.getType() == Product.Type.SHOES).collect(Collectors.toList());

        List<Product> ingredientsCLOTHING = ingrs.stream()
                .filter(p -> p.getType() == Product.Type.CLOTHING).collect(Collectors.toList());

        model.addAttribute("SHOES", ingredientsShoes);
        model.addAttribute("CLOTHING", ingredientsCLOTHING);

    }

    @ModelAttribute(name = "basket")
    public Basket basket() {
        return new Basket();
    }

    @GetMapping("/clothing")
    public String clothingForm() {
        return "clothingForm";
    }

    @GetMapping("/shoes")
    public String shoesForm() {
        return "shoesForm";
    }


    @PostMapping("/clothing")
    public String processBasketClothing(@ModelAttribute Basket basket) {
        System.out.println("BASKET:::" + basket.toString());

        log.info("Processing taco: {}", basket);
        return "redirect:/orders/current";
    }

    @PostMapping("/shoes")
    public String processBasketShoes(@ModelAttribute Basket basket) {
//        System.out.println("BASKET:::" + basket.toString());
//
//        log.info("Processing taco: {}", basket);
        return "redirect:/orders/current";
    }

}
