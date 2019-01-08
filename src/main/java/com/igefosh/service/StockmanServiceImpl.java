package com.igefosh.service;

import com.igefosh.dao.BufferDao;
import com.igefosh.dao.StockmanDao;
import com.igefosh.entity.BufferEntity;
import com.igefosh.entity.OrderEntity;
import com.igefosh.entity.StockmanListEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StockmanServiceImpl implements StockmanService {

    @Autowired
    public StockmanDao stockmanDao;
    @Autowired
    public BufferDao bufferDao;

    /**
     * сохранение набора StockmanListEntity в таблице.
     * @param stockmanListEntitys сохраняемый набор элементов
     */
    public void save(List<StockmanListEntity> stockmanListEntitys) {
        for (StockmanListEntity entity:stockmanListEntitys){
            stockmanDao.save(entity);
        }
    }

    /**
     * удаление всех элементов из таблицы кладовщика
     */
    public void clearAll() {
        stockmanDao.clearAll();
    }

    /**
     * возврат всех значений в таблице кладовщика, упорядоченных по наименованию
     * @return List из StockmanListEntity
     */
    public List<StockmanListEntity> findAll() {
        return stockmanDao.findAll();
    }

    /**
     * возврат всех значений таблицы содержащей наименования таблиц заказов для таблицы кладовщика
     * @return List из  OrderEntity
     */
    public List<OrderEntity> findAllSorders() {
        return stockmanDao.findAllSorders();
    }
    /**
     * сохранение имени и идентификатора таблицы заказа для таблицы кладовщика
     * @param orderEntity
     */
    public void saveToSorders(OrderEntity orderEntity) {
        stockmanDao.saveToSorders(orderEntity);
    }

    /**
     * удаление из таблицы регистрации заказов для таблицы кладовщика
     * @param id ID
     */
    public void deleteFromSorders(int id){
        stockmanDao.deleteFromSorders(id);
    }

    /**
     * создание коллекции объектов StockmanListEntity содержащх всю информацию,
     * необходимую для таблицы кладовщика
     * @return List из StockmanListEntity
     */
    public List<StockmanListEntity> createSListEntitys(){
        List<StockmanListEntity> result = new ArrayList<StockmanListEntity>();
        List<OrderEntity> sorders = findAllSorders();
        for (OrderEntity order:sorders){
            String tableName = order.getName();
            List<BufferEntity> ordersForThisTable = bufferDao.findInTable(tableName);
            for (BufferEntity entity:ordersForThisTable){
                StockmanListEntity stockmanListEntity = new StockmanListEntity();
                stockmanListEntity.setOrder(tableName);
                stockmanListEntity.setArt(entity.getArt());
                stockmanListEntity.setName(entity.getName());
                stockmanListEntity.setShelf(entity.getShelf());
                stockmanListEntity.setBox(entity.getBox());
                stockmanListEntity.setQuantity(entity.getQuantity());
                result.add(stockmanListEntity);
            }
        }
        return result;
    }

    /**
     * удаление заказа: 1 - удаление из таблицы регистрации заказов кладовщику (sorders)
     *                  2 - удаление из таблицы регистрации заказов (orders)
     *                  3 - удаление таблицы содержащей заказ
     * @param tableName имя таблицы содержащей заказ
     */
    public void removeOrder(String tableName) {
        stockmanDao.removeOrder(tableName);
    }
}
