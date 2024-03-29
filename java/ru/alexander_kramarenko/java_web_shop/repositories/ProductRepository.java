package ru.alexander_kramarenko.java_web_shop.repositories;

import ru.alexander_kramarenko.java_web_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
