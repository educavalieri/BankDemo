package com.cavalieri.BanckDemo.services;

import com.cavalieri.BanckDemo.dtos.UserDTO;
import com.cavalieri.BanckDemo.entities.User;
import com.cavalieri.BanckDemo.exceptions.ResourceNotFondException;
import com.cavalieri.BanckDemo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Transactional
//    @Transactional(readOnly = true)
    public UserDTO findById(Long id){

        authService.validateSelfOrAdmin(id);

        User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFondException("User not found"));
        return new UserDTO(entity);

    }


    //-----------------------------------------------------------------------------------
    //authentication zone:

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null){
            logger.error("user not found " + username);
            throw new UsernameNotFoundException("email not found");
        }
        logger.info("user found" + username);
        return user;
    }

}
