package com.cavalieri.BanckDemo.services;

import com.cavalieri.BanckDemo.entities.User;
import com.cavalieri.BanckDemo.repositories.UserRepository;
import com.cavalieri.BanckDemo.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User Authenticated() {

        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findByEmail(userName);
            return user;
        }catch (Exception e){
            throw new UnsupportedOperationException("invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user = Authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }


    }


}