package com.igefosh.dao;

import com.igefosh.entity.OrderEntity;
import com.igefosh.entity.StockmanListEntity;

import java.util.List;
//todo finish this

public interface StockmanDao {

    void save (StockmanListEntity stockmanListEntity);

    void clearAll ();

    List<StockmanListEntity> findAll();

    List<OrderEntity> findAllSorders();

    void saveToSorders (OrderEntity orderEntity);

    void deleteFromSorders(int id);

    void removeOrder(String tableName);

}
