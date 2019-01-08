package com.igefosh.service;

import com.igefosh.entity.BufferEntity;
import com.igefosh.entity.OrderEntity;

import java.util.List;

public interface BufferService {
    BufferEntity getById(int id);

    void save (BufferEntity bufferEntity);

    void clearAll ();

    List<BufferEntity> findAll();

    List<OrderEntity> findOrders();

    List<BufferEntity> findInTable(String tableName);

    void cloneAll(String orderName);
}
