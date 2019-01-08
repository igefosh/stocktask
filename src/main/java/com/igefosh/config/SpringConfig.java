package com.igefosh.config;

import com.igefosh.dao.*;
import com.igefosh.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    @Bean
    public JdbcTemplate getJdbcTamplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/stocktask?useSll=false&?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("mysqlpass");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public ProductDao getProductDao(){
        return new ProductDaoImpl(getJdbcTamplate());
    }

    @Bean
    public ProductService getProductService(){
        return new ProductServiceImpl();
    }

    @Bean
    public BufferDao getBufferDao(){
        return new BufferDaoImpl(getJdbcTamplate());
    }
    @Bean
    public BufferService getBufferService(){
        return new BufferServiceImpl();
    }

    @Bean
    public StockmanDao getStockmanDao() {
        return new StockmanDaoImpl(getJdbcTamplate());
    }
    @Bean
    public StockmanService getStockmanService() {
        return new StockmanServiceImpl();}
}
