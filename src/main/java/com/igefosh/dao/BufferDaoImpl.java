package com.igefosh.dao;

import com.igefosh.entity.BufferEntity;
import com.igefosh.entity.OrderEntity;
import com.igefosh.mapper.BufferMapper;
import com.igefosh.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BufferDaoImpl implements BufferDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public BufferDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * возврат значения таблицы по ID
     * @param id ID
     * @return объект BufferEntity
     */
    public BufferEntity getById(int id) {
        String sql = "SELECT * FROM buffer WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BufferMapper(), id);
    }

    /**
     * сохранение в буфер
     * @param bufferEntity принимает объект содержащий все значения для буфера
     */
    public void save(BufferEntity bufferEntity) {
        String sql = "INSERT INTO buffer (art, name, shelf, box, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, bufferEntity.getArt(), bufferEntity.getName(), bufferEntity.getShelf(),
                bufferEntity.getBox(), bufferEntity.getQuantity());
    }


    /**
     * Удаление всей информации из таблицы буфера
     */
    public void clearAll() {
        String sql = "DELETE FROM buffer";
        jdbcTemplate.execute(sql);
    }

    /**
     * @return List состоящий из BufferEntity
     */
    public List<BufferEntity> findAll() {
        String sql = "SELECT * FROM buffer";
        return jdbcTemplate.query(sql, new BufferMapper());
    }


    /**
     * @return List состоящий из OrderEntity
     */
    public List<OrderEntity> findOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    /**
     * Поиск в указанной таблице
     * @param tableName имя таблицы, которую нужно найти
     * @return list с содержимым найденной таблицы
     */
    public List<BufferEntity> findInTable(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, new BufferMapper());
    }

    /**
     * Создание таблицы содержащей данные заказа и регистрация имени таблицы
     * @param orderName Может быть любое значение, но, на мой взгляд, лучший вариант это имя клиента
     */
    public void cloneAll(String orderName) {
        String cloneSql = "CREATE TABLE " + orderName + " SELECT * FROM buffer;";
        jdbcTemplate.execute(cloneSql);
        String registerSql = "INSERT INTO orders (name) VALUES (?)";
        jdbcTemplate.update(registerSql, orderName);
    }



}
