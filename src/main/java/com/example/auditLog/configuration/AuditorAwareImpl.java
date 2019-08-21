package com.example.auditLog.configuration;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.cloud.sleuth.Tracer;


public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("current user");
    }
}