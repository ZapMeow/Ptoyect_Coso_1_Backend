package levelUp.main.LevelUp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import levelUp.main.LevelUp.model.Product;
import levelUp.main.LevelUp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "product", description = "Product manager")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllBooks(){
        return productService.allProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.findProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product newProduct){
        return productService.saveProduct(newProduct);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product productToChange){
        Product currentProduct = productService.findProductById(id);
        if (currentProduct != null){
            currentProduct.setDescriptionProduct(productToChange.getDescriptionProduct());
            currentProduct.setNameProduct(productToChange.getNameProduct());
            currentProduct.setPriceProduct(productToChange.getPriceProduct());
            currentProduct.setStockProduct(productToChange.getStockProduct());
            currentProduct.setUrlImage(productToChange.getUrlImage());
            currentProduct.setCategoryProduct(productToChange.getCategoryProduct());
            currentProduct.setDistributorProduct(productToChange.getDistributorProduct());
            currentProduct.setLinkDistributor(productToChange.getLinkDistributor());

            productService.saveProduct(currentProduct);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProductById(id);
    }

}
