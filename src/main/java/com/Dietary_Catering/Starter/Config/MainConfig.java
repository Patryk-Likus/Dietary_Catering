package com.Dietary_Catering.Starter.Config;

import com.Dietary_Catering.Starter.DB.Repository.DbUserRepository;
import com.Dietary_Catering.Starter.DB.Repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class MainConfig {


    @Bean(name="DbUserRepository")
    @Profile("prod")
    public DbUserRepository createDBRepo() {
        DbUserRepository repo = new DbUserRepository();
        return repo;
    }

    }

