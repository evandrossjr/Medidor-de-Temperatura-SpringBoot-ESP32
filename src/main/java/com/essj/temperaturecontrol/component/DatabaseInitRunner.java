package com.essj.temperaturecontrol.component;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
@Profile("dev")
public class DatabaseInitRunner {

    private final DataSource dataSource;

    @Value("classpath:sql/create.sql")
    private Resource schemaScript;

    public DatabaseInitRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, schemaScript);
            System.out.println("✅ Script de criação do banco executado.");
        }
    }
}
