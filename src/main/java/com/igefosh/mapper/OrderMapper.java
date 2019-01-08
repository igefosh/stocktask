package com.igefosh.mapper;

import com.igefosh.entity.OrderEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderEntity> {
    public OrderEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(resultSet.getInt("id"));
        orderEntity.setName(resultSet.getString("name"));
        return orderEntity;
    }
}
