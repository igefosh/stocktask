package com.igefosh.dao;

import com.igefosh.entity.Product;
import com.igefosh.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * возврат значения таблицы по ID
     * @param id ID
     * @return объект Product
     */
    public Product getById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
    }


    /**
     * сохранение значений в таблицу продуктов
     * @param product сохраняемый продукт
     */
    public void save(Product product) {
        String sql = "INSERT INTO product (art, name, shelf, box) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getArt(), product.getName(), product.getShelf(),
                product.getBox());
    }

    /**
     * изменение продукта
     * @param product для изменения
     */
    public void update(Product product) {
        String sql = "UPDATE product SET art=?, name=?, shelf=?, box=? WHERE id=?";
        jdbcTemplate.update(sql, product.getArt(), product.getName(), product.getShelf(),
                product.getBox(), product.getId());
    }

    /**
     * удаление продукта из таблицы
     * @param id ID
     */
    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * возврат всех продуктов из таблицы
     * @return List из Product
     */
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductMapper());
    }
}
