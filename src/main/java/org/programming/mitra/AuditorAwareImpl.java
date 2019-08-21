package org.programming.mitra;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Naresh");
        // Can use Spring Security to return currently logged in user
        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }
}