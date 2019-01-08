package com.igefosh.mapper;

import com.igefosh.entity.BufferEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BufferMapper implements RowMapper<BufferEntity> {
    public BufferEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        BufferEntity entity = new BufferEntity();
        entity.setId(resultSet.getInt("id"));
        entity.setArt(resultSet.getString("art"));
        entity.setName(resultSet.getString("name"));
        entity.setShelf(resultSet.getInt("shelf"));
        entity.setBox(resultSet.getString("box"));
        entity.setQuantity(resultSet.getInt("quantity"));
        return entity;
    }
}
