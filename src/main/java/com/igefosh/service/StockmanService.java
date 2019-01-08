package com.igefosh.service;

import com.igefosh.entity.OrderEntity;
import com.igefosh.entity.StockmanListEntity;

import java.util.List;

public interface StockmanService {

    void save (List<StockmanListEntity> stockmanListEntitys);

    void clearAll ();

    List<StockmanListEntity> findAll();

    List<OrderEntity> findAllSorders();

    void saveToSorders (OrderEntity orderEntity);

    void deleteFromSorders(int id);

    List<StockmanListEntity> createSListEntitys();

    void removeOrder(String tableName);

}
