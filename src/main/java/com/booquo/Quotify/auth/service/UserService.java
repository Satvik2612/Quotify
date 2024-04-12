package com.booquo.Quotify.auth.service;

import com.booquo.Quotify.auth.entity.UserEntity;
import com.booquo.Quotify.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public Optional<UserEntity> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public void save(UserEntity userEntity) {
        userRepo.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
