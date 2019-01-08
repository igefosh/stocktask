package com.igefosh.mapper;

import com.igefosh.entity.StockmanListEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockmanListEntryMapper implements RowMapper<StockmanListEntity> {
    public StockmanListEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StockmanListEntity stockmanListEntity = new StockmanListEntity();
        stockmanListEntity.setId(resultSet.getInt("id"));
        stockmanListEntity.setOrder(resultSet.getString("ordername"));
        stockmanListEntity.setArt(resultSet.getString("art"));
        stockmanListEntity.setName(resultSet.getString("name"));
        stockmanListEntity.setShelf(resultSet.getInt("shelf"));
        stockmanListEntity.setBox(resultSet.getString("box"));
        stockmanListEntity.setQuantity(resultSet.getInt("quantity"));
        return stockmanListEntity;
    }
}
