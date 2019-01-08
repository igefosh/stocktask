package com.igefosh.dao;

import com.igefosh.entity.OrderEntity;
import com.igefosh.entity.StockmanListEntity;
import com.igefosh.mapper.OrderMapper;
import com.igefosh.mapper.StockmanListEntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StockmanDaoImpl implements StockmanDao{


    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public StockmanDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * сохранение объекта StockmanListEntity в таблице
     * @param stockmanListEntity сохраняемый элемент
     */
    public void save(StockmanListEntity stockmanListEntity) {
        String sql = "INSERT INTO stockman (ordername, art, name, shelf, box, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, stockmanListEntity.getOrder(), stockmanListEntity.getArt(), stockmanListEntity.getName(), stockmanListEntity.getShelf(),
                stockmanListEntity.getBox(), stockmanListEntity.getQuantity());
    }

    /**
     * удаление всех элементов из таблицы кладовщика
     */
    public void clearAll() {
        String sql = "DELETE FROM stockman";
        jdbcTemplate.execute(sql);
    }

    /**
     * возврат всех значений в таблице кладовщика, упорядоченных по наименованию
     * @return List из StockmanListEntity
     */
    public List<StockmanListEntity> findAll() {
        String sql = "SELECT * FROM stockman ORDER BY name";
        return jdbcTemplate.query(sql, new StockmanListEntryMapper());
    }

    /**
     * возврат всех значений таблицы содержащей наименования таблиц заказов для таблицы кладовщика
     * @return List из  OrderEntity
     */
    public List<OrderEntity> findAllSorders() {
        String sql = "SELECT * FROM sorders";
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    /**
     * сохранение имени и идентификатора таблицы заказа для таблицы кладовщика
     * @param orderEntity
     */
    public void saveToSorders(OrderEntity orderEntity) {
        String sql = "INSERT INTO sorders (id, name) VALUES (?,?)";
        jdbcTemplate.update(sql, orderEntity.getId(), orderEntity.getName());
    }

    /**
     * удаление из таблицы регистрации заказов для таблицы кладовщика
     * @param id ID
     */
    public void deleteFromSorders(int id){
        String sql = "DELETE FROM sorders WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * удаление заказа: 1 - удаление из таблицы регистрации заказов кладовщику (sorders)
     *                  2 - удаление из таблицы регистрации заказов (orders)
     *                  3 - удаление таблицы содержащей заказ
     * @param tableName имя таблицы содержащей заказ
     */
    public void removeOrder(String tableName) {
        String ordersSql = "DELETE FROM orders WHERE name=?";
        String sordersSql = "DELETE FROM sorders WHERE name=?";
        String dropsql = "DROP TABLE " + tableName;
        jdbcTemplate.update(sordersSql, tableName);
        jdbcTemplate.update(ordersSql, tableName);
        jdbcTemplate.execute(dropsql);
    }
}
