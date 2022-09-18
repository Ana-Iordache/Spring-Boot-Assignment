package ro.hubs.ing.springbootproject.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/admin")
    public String displayAdminPage() {
        return "Hi admin!";
    }

}
