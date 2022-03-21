package com.cavalieri.BanckDemo.services;

import com.cavalieri.BanckDemo.dtos.ClientDTO;
import com.cavalieri.BanckDemo.dtos.ClientSaveDTO;
import com.cavalieri.BanckDemo.entities.Client;
import com.cavalieri.BanckDemo.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<ClientDTO> findAllService(){
        List<Client> entity = clientRepository.findAll();
        List<ClientDTO> dto = entity.stream().map(this::entityToDto).collect(Collectors.toList());
        return dto;
    }

    @Transactional
    public ClientDTO findByIdService(Long id){
        Client entity = clientRepository.findById(id).get();
        return this.entityToDto(entity);
    }

    @Transactional
    public ClientDTO saveService(ClientSaveDTO dto){
        Client entity = modelMapper.map(dto, Client.class);
        entity = clientRepository.save(entity);
        return entityToDto(entity);

    }

    public ClientDTO updateService(Long id , ClientSaveDTO dto){
        Client entity = clientRepository.findById(id).get();
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setDocument(dto.getDocument());
        entity.setTitular(dto.getTitular());
        entity = clientRepository.save(entity);
        return modelMapper.map(entity, ClientDTO.class);
    }


    public ClientDTO entityToDto(Client entity){
        return modelMapper.map(entity, ClientDTO.class);

    }

    public Client dtoToEntity(ClientDTO dto){
        return modelMapper.map(dto, Client.class);
    }



}
