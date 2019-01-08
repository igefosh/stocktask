package com.igefosh.entity;

import junit.framework.TestCase;

//К сожалению, у меня пока что нет большого опыта в написании тестов,
//этот формальный тест я оставляю сдесь для соответствия требованиям задания

public class ProductTest extends TestCase {
    Product product = new Product();

    public void testGetName() {
        product.setName("Qwer");
        String name = product.getName();
        assertEquals("Qwer", name);
    }
}