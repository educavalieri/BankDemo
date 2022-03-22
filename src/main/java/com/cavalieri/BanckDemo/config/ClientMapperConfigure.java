package com.cavalieri.BanckDemo.config;

import com.cavalieri.BanckDemo.dtos.ClientDTO;
import com.cavalieri.BanckDemo.entities.Client;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientMapperConfigure {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Client.class, ClientDTO.class).<String>addMapping(
                src -> src.getAccount().getId(),
                (x, y) -> x.setAccountNumber(y)
        );

        return modelMapper;
    }
}
