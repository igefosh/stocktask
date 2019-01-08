package com.igefosh.service;

import com.igefosh.dao.ProductDao;
import com.igefosh.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductDao productDao;

    /**
     * возврат значения таблицы по ID
     * @param id ID
     * @return объект Product
     */
    public Product getById(int id) {
        return productDao.getById(id);
    }

    /**
     * сохранение значений в таблицу продуктов
     * @param product сохраняемый продукт
     */
    public void save(Product product) {
        productDao.save(product);
    }

    /**
     * изменение продукта
     * @param product для изменения
     */
    public void update(Product product) {
        productDao.update(product);
    }

    /**
     * удаление продукта из таблицы
     * @param id ID
     */
    public void delete(int id) {
        productDao.delete(id);
    }

    /**
     * возврат всех продуктов из таблицы
     * @return List из Product
     */
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
