package com.Dietary_Catering.Starter.Config;

import com.Dietary_Catering.Starter.DB.Repository.DbFoodRepository;
import com.Dietary_Catering.Starter.DB.Repository.DbHistoryRepository;
import com.Dietary_Catering.Starter.DB.Repository.DbUserRepository;
import com.Dietary_Catering.Starter.DB.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;

public class MainConfig {


    @Bean(name="DbUserRepository")
    @Profile("prod")
    public DbUserRepository createDBUserRepo(EntityManager entityManager) {
        DbUserRepository repo = new DbUserRepository(entityManager);
        return repo;
    }

    @Bean(name="DbFoodRepository")
    @Profile("prod")
    public DbFoodRepository createDBFoodRepo(EntityManager entityManager) {
        DbFoodRepository repo = new DbFoodRepository(entityManager);
        return repo;
    }


    @Bean(name="DbHistoryRepository")
    @Profile("prod")
    public DbHistoryRepository createDBHistoryRepo(EntityManager entityManager) {
        DbHistoryRepository repo = new DbHistoryRepository(entityManager);
        return repo;
    }

    }

