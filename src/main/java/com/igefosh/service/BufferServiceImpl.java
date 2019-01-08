package com.igefosh.service;

import com.igefosh.dao.BufferDao;
import com.igefosh.entity.BufferEntity;
import com.igefosh.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BufferServiceImpl implements BufferService{

    @Autowired
    public BufferDao bufferDao;

    /**
     * возврат значения таблицы по ID
     * @param id ID
     * @return объект BufferEntity
     */
    public BufferEntity getById(int id) {
        return bufferDao.getById(id);
    }

    /**
     * сохранение в буфер
     * @param bufferEntity принимает объект содержащий все значения для буфера
     */
    public void save(BufferEntity bufferEntity) {
        bufferDao.save(bufferEntity);
    }

    /**
     * Удаление всей информации из таблицы буфера
     */
    public void clearAll() {
        bufferDao.clearAll();
    }

    /**
     * @return List состоящий из BufferEntity
     */
    public List<BufferEntity> findAll() {
        return bufferDao.findAll();
    }

    /**
     * @return List состоящий из OrderEntity
     */
    public List<OrderEntity> findOrders() {
        return bufferDao.findOrders();
    }


    /**
     * Поиск в указанной таблице
     * @param tableName имя таблицы, которую нужно найти
     * @return list с содержимым найденной таблицы
     */
    public List<BufferEntity> findInTable (String tableName) {
        return bufferDao.findInTable(tableName);
    }

    /**
     * Создание таблицы содержащей данные заказа и регистрация имени таблицы
     * @param orderName Может быть любое значение, но, на мой взгляд, лучший вариант это имя клиента
     */
    public void cloneAll(String orderName) {
        bufferDao.cloneAll(orderName);
    }
}
