package com.igefosh.entity;

/**
 * Объект для таблицы регистрации заказов (orders) и регистрации заказов для кладовщика (sorders)
 */
public class OrderEntity {
    private int id;
    private String name;

    public OrderEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
