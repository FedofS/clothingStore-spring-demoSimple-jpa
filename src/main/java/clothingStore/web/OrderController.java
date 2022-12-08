package clothingStore.web;


import clothingStore.Basket;
import clothingStore.entity.BasketRepository;
import clothingStore.entity.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("basket")
public class OrderController {


    private BasketRepository basketRepository;

    public OrderController(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @GetMapping("/current")
    public String orderForm(Basket basket) {
        log.info("Processing taco: {}", basket);
        return "orderForm";
    }

    @PostMapping
    public String processOrder( Basket basket, SessionStatus sessionStatus) {
        log.info("Basket submitted: {}", basket);

        basketRepository.save(basket);
        sessionStatus.setComplete();
        return "redirect:/";
    }

}
