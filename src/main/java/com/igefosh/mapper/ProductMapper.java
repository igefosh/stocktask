package com.igefosh.mapper;

import com.igefosh.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setArt(resultSet.getString("art"));
        product.setName(resultSet.getString("name"));
        product.setShelf(resultSet.getInt("shelf"));
        product.setBox(resultSet.getString("box"));
        return product;
    }
}
