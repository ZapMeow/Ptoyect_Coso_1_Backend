package levelUp.main.LevelUp.service;

import levelUp.main.LevelUp.model.Product;
import levelUp.main.LevelUp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(long id){
        productRepository.deleteById(id);
    }




}
