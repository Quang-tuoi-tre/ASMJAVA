package mu.ronaldo.lienquan.Asm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping(value= "/")
    public String Welcome (){
        return "Book Home Store";
    }
}
