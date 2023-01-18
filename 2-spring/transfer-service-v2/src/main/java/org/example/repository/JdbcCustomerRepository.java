package org.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcCustomerRepository implements CustomerRepository {

    private DataSource dataSource;

    @Autowired
    public JdbcCustomerRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


}
