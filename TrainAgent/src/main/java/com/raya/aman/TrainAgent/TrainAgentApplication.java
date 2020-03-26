package com.raya.aman.TrainAgent;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class TrainAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainAgentApplication.class, args);
	}

    @Autowired
    private Environment env;

    @Bean
    @Primary
    DataSource dataSource() {
        BoneCPConfig boneCPConfig = new BoneCPConfig();
        boneCPConfig.setUser(env.getProperty("database.username.TA"));
        boneCPConfig.setJdbcUrl(env.getProperty("database.URL.TA"));
        boneCPConfig.setPassword(env.getProperty("database.password.TA"));
        BoneCPDataSource dataSource = new BoneCPDataSource(boneCPConfig);
        return dataSource;
    }
    @Bean
    SpringLiquibase liquibase() throws SQLException {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(env.getProperty("liquibase.filepath"));
        liquibase.setDataSource(dataSource());
        return liquibase;
    }
}
